package wyyu.multi.litho.base;

import android.content.Context;
import android.view.View;
import com.facebook.litho.Component;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.ComponentLifecycle;
import com.facebook.litho.LithoView;
import com.facebook.litho.StateContainer;

/**
 * Created by wyyu on 2019-10-12.
 **/

public abstract class AbsComponent<T> extends Component implements IComponent<T> {

    private ComponentCore componentCore;

    protected T data;

    public AbsComponent(String simpleName) {
        super(simpleName);
        componentCore = new ComponentCore(simpleName);
        data = null;
    }

    @Override public AbsComponent makeShallowCopy() {
        AbsComponent componentCopy = (AbsComponent) super.makeShallowCopy();
        componentCopy.componentCore = componentCore;
        return componentCopy;
    }

    @Override protected Component onCreateLayout(ComponentContext componentContext) {
        return componentCore.onCreateLayout(componentContext);
    }

    @Override public void setViewData(T data) {
        this.data = data;
        this.componentCore.updateState();
    }

    @Override public View createView(Context context) {
        return LithoView.create(context, this);
    }

    private class ComponentCore extends Component {

        private ComponentCore(String simpleName) {
            super(simpleName + "Core");
        }

        @Override protected Component onCreateLayout(ComponentContext componentContext) {
            setScopedContext(componentContext);

            return createLayout(componentContext, data);
        }

        @Override public boolean hasState() {
            return true;
        }

        private void updateState() {
            ComponentContext context = getScopedContext();
            if (context != null) {
                context.updateStateAsync(new CoreUpdate(), getSimpleName() + " -> updateData");
            }
        }
    }

    private static final class CoreUpdate implements ComponentLifecycle.StateUpdate {

        @Override public void updateState(StateContainer stateContainer) {

        }
    }
}