package wyyu.multi.litho.component;

import android.text.TextUtils;
import android.view.WindowManager;
import android.widget.ImageView;
import com.facebook.litho.ClickEvent;
import com.facebook.litho.Column;
import com.facebook.litho.Component;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.EventHandler;
import com.facebook.litho.Row;
import com.facebook.litho.widget.Image;
import com.facebook.litho.widget.Text;
import com.facebook.yoga.YogaEdge;
import com.jeremyliao.liveeventbus.LiveEventBus;
import wyyu.multi.R;
import wyyu.multi.litho.base.AbsComponent;
import wyyu.multi.litho.data.DataTest;
import wyyu.multi.litho.event.EventRefreshLitho;

/**
 * Created by wyyu on 2019-10-12.
 **/

public class ComponentCell extends AbsComponent<DataTest> {

    public ComponentCell() {
        super("ComponentCell");
    }

    @Override public Component createLayout(ComponentContext context, DataTest dataTest) {
        String index = dataTest == null ? "-1" : String.valueOf(dataTest.index);
        String content = dataTest == null ? "空内容" : dataTest.content;
        int resId = dataTest == null ? R.mipmap.ic_launcher : dataTest.resId;

        return Column.create(context)
            .widthDip(WindowManager.LayoutParams.MATCH_PARENT)
            .heightDip(WindowManager.LayoutParams.WRAP_CONTENT)
            .child(Row.create(context)
                .paddingDip(YogaEdge.HORIZONTAL, 14.0f)
                .paddingDip(YogaEdge.VERTICAL, 12.0f)
                .child(Text.create(context)
                    .textSizeDip(15.0f)
                    .textColor(0xff333333)
                    .minWidthDip(32.0f)
                    .clickHandler(new EventHandler<ClickEvent>(this, 0, new Object[] { index }))
                    .text(index)
                    .build())
                .child(Column.create(context)
                    .marginDip(YogaEdge.LEFT, 14.0f)
                    .child(Text.create(context)
                        .textSizeDip(15.0f)
                        .textColor(0xff333333)
                        .minWidthDip(32.0f)
                        .ellipsize(TextUtils.TruncateAt.END)
                        .spacingMultiplier(1.3f)
                        .maxLines(2)
                        .text(content)
                        .build())
                    .child(Image.create(context)
                        .marginDip(YogaEdge.TOP, 8.0f)
                        .heightDip(210.0f)
                        .scaleType(ImageView.ScaleType.CENTER_CROP)
                        .drawableRes(resId)
                        .build()))
                .build())
            .child(Row.create(context)
                .widthDip(WindowManager.LayoutParams.MATCH_PARENT)
                .heightDip(0.4f)
                .backgroundColor(0xffc0c0c0)
                .build())
            .build();
    }

    @Override
    public Object dispatchOnEvent(final EventHandler eventHandler, final Object eventState) {
        if (eventHandler.id == 0) {
            data.index = data.index + 102;
            LiveEventBus.get().with(EventRefreshLitho.EVENT).setValue(new EventRefreshLitho(data));
        }
        return null;
    }
}
