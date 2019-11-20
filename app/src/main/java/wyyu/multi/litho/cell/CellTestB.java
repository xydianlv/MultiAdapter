package wyyu.multi.litho.cell;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;
import com.wyyu.expand.BindCell;
import com.wyyu.expand.CellView;
import com.wyyu.multi.cell.IHolderCell;
import wyyu.multi.litho.data.DataTest;
import wyyu.multi.R;

/**
 * Created by wyyu on 2019-10-11.
 **/

@BindCell(R.layout.layout_cell_multi_b) public class CellTestB implements IHolderCell {

    @CellView(R.id.item_multi_index) TextView itemIndex;
    @CellView(R.id.item_multi_img) ImageView imageView;

    @Override public void cacheCell(@NonNull Object item) {
        DataTest dataCell = (DataTest) item;

        itemIndex.setText(String.valueOf(dataCell.index));
        imageView.setImageResource(dataCell.resId);
    }

    @Override public void bindParams(@Nullable Object... params) {

    }

    @Override public void updateCell(@NonNull Object item, int updateType, Object... params) {

    }
}
