package wyyu.multi.litho.base;

import android.content.Context;
import android.view.View;
import com.facebook.litho.Component;
import com.facebook.litho.ComponentContext;

/**
 * Created by wyyu on 2019-10-12.
 **/

public interface IComponent<T> {

    /**
     * 创建一个构建 LithoView 的 Component
     *
     * @param context 初始化 Component 的 ComponentContext
     * @param data 往组件中填充的数据
     * @return 可创建 LithoView 的 的Component
     */
    Component createLayout(ComponentContext context, T data);

    /**
     * 传入自定义控件需要展示的数据
     *
     * @param data 数据集合
     */
    void setViewData(T data);

    /**
     * 生成 LithoView
     *
     * @param context 生成 LithoView 需要的 Context
     * @return LithoView
     */
    View createView(Context context);
}
