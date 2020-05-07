package wyyu.multi.cell_integer.data;

import wyyu.multi.app.Constants;

/**
 * Created by wyyu on 2020-05-07.
 **/

public class DataIntegerA implements IIntegerData {

    public int index;

    public int resId;

    public String content;

    public DataIntegerA(int index) {
        this.index = index;
        this.resId = Constants.RES_ID;
        this.content = Constants.CONTENT;
    }

    @Override public int loadDataType() {
        return IIntegerData.DATA_A;
    }
}
