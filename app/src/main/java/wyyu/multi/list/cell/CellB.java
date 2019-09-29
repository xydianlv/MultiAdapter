package wyyu.multi.list.cell;

import android.support.annotation.NonNull;
import android.widget.TextView;
import com.wyyu.expand.BindCell;
import com.wyyu.expand.CellView;
import com.wyyu.multi.cell.IHolderCell;
import wyyu.multi.R;
import wyyu.multi.list.data.DataB;

/**
 * Created by wyyu on 2019-09-29.
 **/

@BindCell(R.layout.layout_cell_text_b) public class CellB implements IHolderCell {

    @CellView(R.id.cell_text_b) TextView textView;

    @Override public void cacheCell(@NonNull Object item) {
        textView.setText(String.valueOf(((DataB) item).index));
    }

    @Override public void updateCell(@NonNull Object item, int updateType) {

    }
}
