package wyyu.multi.litho.component;

import android.text.TextUtils;
import android.view.WindowManager;
import android.widget.ImageView;
import com.facebook.litho.ClickEvent;
import com.facebook.litho.Column;
import com.facebook.litho.Component;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.ComponentLifecycle;
import com.facebook.litho.EventHandler;
import com.facebook.litho.Row;
import com.facebook.litho.StateContainer;
import com.facebook.litho.widget.Image;
import com.facebook.litho.widget.Text;
import com.facebook.yoga.YogaEdge;
import com.jeremyliao.liveeventbus.LiveEventBus;
import wyyu.multi.litho.data.DataTest;
import wyyu.multi.R;
import wyyu.multi.litho.event.EventRefreshLitho;

/**
 * Created by wyyu on 2019-10-11.
 **/

class LithoTest extends Component {

    private DataTest dataCell;

    LithoTest() {
        super("LithoTest");
        dataCell = null;
    }

    @Override protected Component onCreateLayout(ComponentContext componentContext) {
        setScopedContext(componentContext);

        String index = dataCell == null ? "-1" : String.valueOf(dataCell.index);
        String content = dataCell == null ? "空内容" : dataCell.content;
        int resId = dataCell == null ? R.mipmap.ic_launcher : dataCell.resId;

        return Column.create(componentContext)
            .widthDip(WindowManager.LayoutParams.MATCH_PARENT)
            .heightDip(WindowManager.LayoutParams.WRAP_CONTENT)
            .child(Row.create(componentContext)
                .paddingDip(YogaEdge.HORIZONTAL, 14.0f)
                .paddingDip(YogaEdge.VERTICAL, 12.0f)
                .child(Text.create(componentContext)
                    .textSizeDip(15.0f)
                    .textColor(0xff333333)
                    .minWidthDip(32.0f)
                    .clickHandler(new EventHandler<ClickEvent>(this, 0, new Object[] { index }))
                    .text(index)
                    .build())
                .child(Column.create(componentContext)
                    .marginDip(YogaEdge.LEFT, 14.0f)
                    .child(Text.create(componentContext)
                        .textSizeDip(15.0f)
                        .textColor(0xff333333)
                        .minWidthDip(32.0f)
                        .ellipsize(TextUtils.TruncateAt.END)
                        .spacingMultiplier(1.3f)
                        .maxLines(2)
                        .text(content)
                        .build())
                    .child(Image.create(componentContext)
                        .marginDip(YogaEdge.TOP, 8.0f)
                        .heightDip(210.0f)
                        .scaleType(ImageView.ScaleType.CENTER_CROP)
                        .drawableRes(resId)
                        .build()))
                .build())
            .child(Row.create(componentContext)
                .widthDip(WindowManager.LayoutParams.MATCH_PARENT)
                .heightDip(0.4f)
                .backgroundColor(0xffc0c0c0)
                .build())
            .build();
    }

    @Override public boolean hasState() {
        return true;
    }

    @Override
    public Object dispatchOnEvent(final EventHandler eventHandler, final Object eventState) {
        if (eventHandler.id == 0) {
            dataCell.index = dataCell.index + 102;
            LiveEventBus.get()
                .with(EventRefreshLitho.EVENT)
                .setValue(new EventRefreshLitho(dataCell));
        }
        return null;
    }

    void setCellData(DataTest dataCell) {
        this.dataCell = dataCell;

        ComponentContext context = getScopedContext();
        if (context != null) {
            context.updateStateAsync(new CellUpdate(), "SimpleInfo.refreshInfo");
        }
    }

    private static final class CellUpdate implements ComponentLifecycle.StateUpdate {

        @Override public void updateState(StateContainer stateContainer) {

        }
    }
}
