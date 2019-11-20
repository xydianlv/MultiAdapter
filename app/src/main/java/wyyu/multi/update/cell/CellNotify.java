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
import wyyu.multi.update.event.EventNotifyItem;
import wyyu.multi.update.data.DataNotify;
import wyyu.multi.update.player.CellPlayer;
import wyyu.multi.update.player.PlayerListener;

/**
 * Created by wyyu on 2019-10-08.
 **/

@BindCell(R.layout.layout_cell_notify) public class CellNotify implements IHolderCell {

    @CellView(R.id.cell_notify_index) TextView itemIndex;
    @CellView(R.id.cell_notify_play) TextView playAnim;
    @CellView(R.id.cell_notify_num) TextView number;

    @Override public void cacheCell(@NonNull Object item) {
        DataNotify dataNotify = (DataNotify) item;

        cacheValue(dataNotify);
        cachePlay(dataNotify);
    }

    @Override public void bindParams(@Nullable Object... params) {

    }

    @Override public void updateCell(@NonNull Object item, int updateType, Object... params) {

    }

    private void cacheValue(final DataNotify dataNotify) {
        itemIndex.setText(String.valueOf(dataNotify.index));

        number.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                dataNotify.num++;
                LiveEventBus.get()
                    .with(EventNotifyItem.EVENT)
                    .postValue(new EventNotifyItem(dataNotify));
            }
        });

        refreshNumber(dataNotify.num);
        refreshAnim(0);
    }

    private void cachePlay(final DataNotify dataNotify) {
        playAnim.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                onClickPlay(dataNotify);
            }
        });
        CellPlayer.getPlayer().cancel();
    }

    private void onClickPlay(DataNotify dataNotify) {
        CellPlayer.getPlayer().play(dataNotify.index, new PlayerListener() {
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
}
