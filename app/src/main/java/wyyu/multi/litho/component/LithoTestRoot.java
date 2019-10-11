package wyyu.multi.litho.component;

import com.facebook.litho.Component;
import com.facebook.litho.ComponentContext;
import wyyu.multi.litho.data.DataTest;

/**
 * Created by wyyu on 2019-10-11.
 **/

public class LithoTestRoot extends Component {

    private LithoTest lithoCell;

    public LithoTestRoot() {
        super("LithoTestRoot");
        lithoCell = new LithoTest();
    }

    @Override public LithoTestRoot makeShallowCopy() {
        LithoTestRoot rootCopy = (LithoTestRoot) super.makeShallowCopy();
        rootCopy.lithoCell = lithoCell;
        return rootCopy;
    }

    @Override protected Component onCreateLayout(ComponentContext componentContext) {
        return lithoCell.onCreateLayout(componentContext);
    }

    public void setDefineData(DataTest dataCell) {
        lithoCell.setCellData(dataCell);
    }
}