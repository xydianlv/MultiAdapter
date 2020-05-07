package wyyu.multi.cell_class.cell;

import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.wyyu.expand.BindCell;
import com.wyyu.expand.CellView;
import com.wyyu.multi.cell.IHolderCell;
import wyyu.multi.R;
import wyyu.multi.cell_class.data.DataClassB;

/**
 * Created by wyyu on 2020-05-07.
 **/

@BindCell(R.layout.layout_cell_class_b) public class CellClassB implements IHolderCell {

    @CellView(R.id.cell_class_b_image) ImageView itemImage;
    @CellView(R.id.cell_class_b_index) TextView itemIndex;

    @Override public void cacheCell(@NonNull Object item) {
        if (!(item instanceof DataClassB)) {
            return;
        }

        DataClassB data = (DataClassB) item;

        itemImage.setImageResource(data.resId);
        itemIndex.setText(String.valueOf(data.index));
    }

    @Override public void bindParams(@Nullable Object... params) {

    }

    @Override public void updateCell(int updateType, Object... params) {

    }
}
