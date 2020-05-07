package wyyu.multi.cell_class.data;

import wyyu.multi.app.Constants;

/**
 * Created by wyyu on 2020-05-07.
 **/

public class DataClassB {

    public int index;

    public int resId;

    public String content;

    public DataClassB(int index) {
        this.index = index;
        this.resId = Constants.RES_ID;
        this.content = Constants.CONTENT;
    }
}
