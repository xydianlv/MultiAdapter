package wyyu.multi.cell_integer.cell;

import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.wyyu.expand.BindCell;
import com.wyyu.expand.CellView;
import com.wyyu.multi.cell.IHolderCell;
import wyyu.multi.R;
import wyyu.multi.cell_integer.data.DataIntegerB;

/**
 * Created by wyyu on 2020-05-07.
 **/

@BindCell(R.layout.layout_cell_integer_b) public class CellIntegerB implements IHolderCell {

    @CellView(R.id.cell_integer_b_image) ImageView itemImage;
    @CellView(R.id.cell_integer_b_index) TextView itemIndex;

    @Override public void cacheCell(int index, @NonNull Object item) {
        if (!(item instanceof DataIntegerB)) {
            return;
        }

        DataIntegerB data = (DataIntegerB) item;

        itemImage.setImageResource(data.resId);
        itemIndex.setText(String.valueOf(data.index));
    }

    @Override public void bindParams(int index, @Nullable Object... params) {

    }

    @Override public void updateCell(int updateType, Object... params) {

    }
}
