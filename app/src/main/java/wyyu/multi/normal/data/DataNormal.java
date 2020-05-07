package wyyu.multi.normal.data;

import wyyu.multi.app.Constants;

/**
 * Created by wyyu on 2020-05-07.
 **/

public class DataNormal {

    public int index;

    public int resId;

    public String content;

    public DataNormal(int index) {
        this.index = index;
        this.resId = Constants.RES_ID;
        this.content = Constants.CONTENT;
    }
}
