package wyyu.multi.update.cell;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.wyyu.expand.BindCell;
import com.wyyu.expand.CellView;
import com.wyyu.multi.cell.IHolderCell;
import wyyu.multi.R;
import wyyu.multi.update.data.DataUpdate;
import wyyu.multi.update.event.EventOnClickContent;
import wyyu.multi.update.event.EventUpdateItem;
import wyyu.multi.update.player.CellPlayer;
import wyyu.multi.update.player.PlayerListener;

/**
 * Created by wyyu on 2019-10-08.
 **/

@BindCell(R.layout.layout_cell_update) public class CellUpdate implements IHolderCell {

    public static final int UPDATE_A = 0;

    @CellView(R.id.cell_update_content) TextView content;
    @CellView(R.id.cell_update_index) TextView itemIndex;
    @CellView(R.id.cell_update_play) TextView playAnim;
    @CellView(R.id.cell_update_num) TextView number;

    @Override public void cacheCell(@NonNull Object item) {
        DataUpdate dataUpdate = (DataUpdate) item;

        cacheContent(dataUpdate);
        cacheValue(dataUpdate);
        cachePlay(dataUpdate);
    }

    @Override public void bindParams(@Nullable Object... params) {

    }

    @Override public void updateCell(@NonNull Object item, int updateType, Object... params) {
        if (updateType == UPDATE_A) {
            refreshNumber(((DataUpdate) item).num);
        }
    }

    private void cacheContent(final DataUpdate dataUpdate) {
        content.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                LiveEventBus.get()
                    .with(EventOnClickContent.EVENT)
                    .setValue(new EventOnClickContent(dataUpdate.index));
            }
        });
    }

    private void cacheValue(final DataUpdate dataUpdate) {
        itemIndex.setText(String.valueOf(dataUpdate.index));

        number.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                dataUpdate.num++;
                LiveEventBus.get()
                    .with(EventUpdateItem.EVENT)
                    .postValue(new EventUpdateItem(dataUpdate));
            }
        });

        refreshNumber(dataUpdate.num);
        refreshAnim(0);
    }

    private void cachePlay(final DataUpdate dataUpdate) {
        playAnim.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                onClickPlay(dataUpdate);
            }
        });
        CellPlayer.getPlayer().cancel();
    }

    private void onClickPlay(DataUpdate dataUpdate) {
        CellPlayer.getPlayer().play(dataUpdate.index, new PlayerListener() {
            @Override public void onPlay(int data) {
                refreshAnim(data);
            }
        });
    }

    private void refreshNumber(int num) {
        number.setText(String.valueOf(num));
    }

    private void refreshAnim(int data) {
        playAnim.setText(data == 0 ? "Play" : String.valueOf(data));
    }

    public void refreshTextColor(int value) {
        if (content == null) {
            return;
        }
        content.setTextColor(value % 2 == 0 ? 0xff333333 : 0xff5989E7);
    }
}
