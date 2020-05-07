package wyyu.multi.cell_integer.cell;

import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.wyyu.expand.BindCell;
import com.wyyu.expand.CellView;
import com.wyyu.multi.cell.IHolderCell;
import wyyu.multi.R;
import wyyu.multi.cell_integer.data.DataIntegerA;

/**
 * Created by wyyu on 2020-05-07.
 **/

@BindCell(R.layout.layout_cell_integer_a) public class CellIntegerA implements IHolderCell {

    @CellView(R.id.cell_integer_a_content) TextView itemContent;
    @CellView(R.id.cell_integer_a_index) TextView itemIndex;

    @Override public void cacheCell(@NonNull Object item) {
        if (!(item instanceof DataIntegerA)) {
            return;
        }

        DataIntegerA data = (DataIntegerA) item;

        itemContent.setText(String.valueOf(data.content));
        itemIndex.setText(String.valueOf(data.index));
    }

    @Override public void bindParams(@Nullable Object... params) {

    }

    @Override public void updateCell(int updateType, Object... params) {

    }
}
