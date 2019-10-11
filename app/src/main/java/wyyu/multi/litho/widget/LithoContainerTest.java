package wyyu.multi.litho.widget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/**
 * Created by wyyu on 2019-10-11.
 **/

public class LithoContainerTest extends FrameLayout {

    public LithoContainerTest(@NonNull Context context) {
        super(context);
    }

    public LithoContainerTest(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public LithoContainerTest(@NonNull Context context, @Nullable AttributeSet attrs,
        int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override public void offsetTopAndBottom(int offset) {
        super.offsetTopAndBottom(offset);

        for (int index = 0; index < getChildCount(); index++) {
            getChildAt(index).offsetTopAndBottom(0);
        }
    }
}
