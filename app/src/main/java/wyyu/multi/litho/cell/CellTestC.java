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
 *
 * 使用 LithoView 在构建 ViewHolder 时，当 Adapter 调用 notifyItemRemoved 方法，屏幕外的 LithoView 没有正常加载
 *
 * 原因 ：Adapter 调用 notifyItemRemoved 时，回调到 RecyclerView 中，只做了 removeChildView 操作，不会触发
 * offsetTopAndBottom 方法，屏幕外的 LithoView 就不会触发加载逻辑
 *
 * 解决方案 ：在调用 notifyItemRemoved 方法后，让 RecyclerView 调用 scrollBy 方法，给 RecyclerView 一个 1px 的位移，用来触发
 * offsetTopAndBottom 方法，继而使屏幕外因 notifyItemRemoved 移入屏幕内的 LithoView 可正常绘制
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

    @Override public void updateCell(@NonNull Object item, int updateType, Object... params) {
        if (updateType == UPDATE_A) {
            componentCell.setViewData((DataTest) item);
        }
    }
}
