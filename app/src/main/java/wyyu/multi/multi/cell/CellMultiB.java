package wyyu.multi.multi.cell;

import android.support.annotation.NonNull;
import android.widget.ImageView;
import com.wyyu.expand.BindCell;
import com.wyyu.expand.CellView;
import com.wyyu.multi.cell.IHolderCell;
import wyyu.multi.R;
import wyyu.multi.multi.data.DataMulti;

/**
 * Created by wyyu on 2019-09-29.
 **/

@BindCell(R.layout.layout_cell_multi_b) public class CellMultiB implements IHolderCell {

    @CellView(R.id.item_multi_img) ImageView imageView;

    @Override public void cacheCell(@NonNull Object item) {
        imageView.setImageResource(((DataMulti) item).resId);
    }

    @Override public void updateCell(@NonNull Object item, int updateType) {

    }
}
