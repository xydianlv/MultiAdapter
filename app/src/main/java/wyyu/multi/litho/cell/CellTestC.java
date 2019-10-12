package wyyu.multi.litho.cell;

import android.support.annotation.NonNull;
import android.view.View;
import com.facebook.litho.LithoView;
import com.wyyu.expand.BindCell;
import com.wyyu.multi.cell.IHolderCellWithCreate;
import wyyu.multi.R;
import wyyu.multi.litho.component.LithoTestRoot;
import wyyu.multi.litho.data.DataTest;
import wyyu.multi.litho.widget.LithoContainerTest;

/**
 * Created by wyyu on 2019-10-11.
 **/

@BindCell(R.layout.layout_cell_litho_t) public class CellTestC implements IHolderCellWithCreate {

    public static final int UPDATE_A = 0;

    private LithoTestRoot cellRoot;

    @Override public void onCreateView(@NonNull View itemView) {
        if (!(itemView instanceof LithoContainerTest)) {
            return;
        }

        LithoContainerTest container = (LithoContainerTest) itemView;
        container.removeAllViews();

        cellRoot = new LithoTestRoot();
        container.addView(LithoView.create(itemView.getContext(), cellRoot));
    }

    @Override public void cacheCell(@NonNull Object item) {
        cellRoot.setDefineData((DataTest) item);
    }

    @Override public void updateCell(@NonNull Object item, int updateType) {
        if (updateType == UPDATE_A) {
            cellRoot.setDefineData((DataTest) item);
        }
    }
}
