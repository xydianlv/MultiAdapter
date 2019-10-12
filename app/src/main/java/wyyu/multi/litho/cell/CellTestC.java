package wyyu.multi.litho.cell;

import android.support.annotation.NonNull;
import android.view.View;
import com.wyyu.expand.BindCell;
import com.wyyu.multi.cell.IHolderCellWithCreate;
import wyyu.multi.R;
import wyyu.multi.litho.component.ComponentCell;
import wyyu.multi.litho.data.DataTest;
import wyyu.multi.litho.widget.LithoContainerTest;

/**
 * Created by wyyu on 2019-10-11.
 **/

@BindCell(R.layout.layout_cell_litho_t) public class CellTestC implements IHolderCellWithCreate {

    public static final int UPDATE_A = 0;

    private ComponentCell componentCell;

    @Override public void onCreateView(@NonNull View itemView) {
        if (!(itemView instanceof LithoContainerTest)) {
            return;
        }

        LithoContainerTest container = (LithoContainerTest) itemView;
        container.removeAllViews();

        componentCell = new ComponentCell();
        container.addView(componentCell.createView(itemView.getContext()));
    }

    @Override public void cacheCell(@NonNull Object item) {
        componentCell.setViewData((DataTest) item);
    }

    @Override public void updateCell(@NonNull Object item, int updateType) {
        if (updateType == UPDATE_A) {
            componentCell.setViewData((DataTest) item);
        }
    }
}
