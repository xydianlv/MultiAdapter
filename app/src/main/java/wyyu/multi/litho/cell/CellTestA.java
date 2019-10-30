package wyyu.multi.litho.cell;

import android.support.annotation.NonNull;
import android.widget.TextView;
import com.wyyu.expand.BindCell;
import com.wyyu.expand.CellView;
import com.wyyu.multi.cell.IHolderCell;
import wyyu.multi.litho.data.DataTest;
import wyyu.multi.R;

/**
 * Created by wyyu on 2019-10-11.
 **/

@BindCell(R.layout.layout_cell_multi_a) public class CellTestA implements IHolderCell {

    @CellView(R.id.item_multi_index) TextView itemIndex;
    @CellView(R.id.item_multi_text) TextView textView;

    @Override public void cacheCell(@NonNull Object item) {

        DataTest dataCell = (DataTest) item;

        itemIndex.setText(String.valueOf(dataCell.index));
        textView.setText(dataCell.content);
    }

    @Override public void updateCell(@NonNull Object item, int updateType, Object... params) {

    }
}
