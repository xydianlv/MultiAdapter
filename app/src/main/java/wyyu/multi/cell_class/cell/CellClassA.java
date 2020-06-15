package wyyu.multi.cell_class.cell;

import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.wyyu.expand.BindCell;
import com.wyyu.expand.CellView;
import com.wyyu.multi.cell.IHolderCell;
import wyyu.multi.R;
import wyyu.multi.cell_class.data.DataClassA;

/**
 * Created by wyyu on 2020-05-07.
 **/

@BindCell(R.layout.layout_cell_class_a) public class CellClassA implements IHolderCell {

    @CellView(R.id.cell_class_a_content) TextView itemContent;
    @CellView(R.id.cell_class_a_index) TextView itemIndex;

    @Override public void cacheCell(int index, @NonNull Object item) {
        if (!(item instanceof DataClassA)) {
            return;
        }

        DataClassA data = (DataClassA) item;

        itemContent.setText(data.content);
        itemIndex.setText(String.valueOf(data.index));
    }

    @Override public void bindParams(int index, @Nullable Object... params) {

    }

    @Override public void updateCell(int updateType, Object... params) {

    }
}
