package wyyu.multi.multi.cell;

import android.support.annotation.NonNull;
import android.widget.TextView;
import com.wyyu.expand.BindCell;
import com.wyyu.expand.CellView;
import com.wyyu.multi.cell.IHolderCell;
import wyyu.multi.R;
import wyyu.multi.multi.data.DataMulti;

/**
 * Created by wyyu on 2019-09-29.
 **/

@BindCell(R.layout.layout_cell_multi_a) public class CellMultiA implements IHolderCell {

    @CellView(R.id.item_multi_text) TextView textView;

    @Override public void cacheCell(@NonNull Object item) {
        textView.setText(((DataMulti) item).content);
    }

    @Override public void updateCell(@NonNull Object item, int updateType) {

    }
}
