package wyyu.multi.multi.cell;

import android.support.annotation.NonNull;
import android.widget.ImageView;
import android.widget.TextView;
import com.wyyu.expand.BindCell;
import com.wyyu.expand.CellView;
import com.wyyu.multi.cell.IHolderCell;
import wyyu.multi.R;
import wyyu.multi.multi.data.DataMulti;

/**
 * Created by wyyu on 2019-09-29.
 **/

@BindCell(R.layout.layout_cell_multi_c) public class CellMultiC implements IHolderCell {

    @CellView(R.id.item_multi_text) TextView textView;
    @CellView(R.id.item_multi_img) ImageView imageView;
    @CellView(R.id.item_multi_index) TextView itemIndex;

    @Override public void cacheCell(@NonNull Object item) {
        DataMulti dataMulti = (DataMulti) item;

        textView.setText(dataMulti.content);
        imageView.setImageResource(dataMulti.resId);
        itemIndex.setText(String.valueOf(dataMulti.index));
    }

    @Override public void updateCell(@NonNull Object item, int updateType, Object... params) {

    }
}
