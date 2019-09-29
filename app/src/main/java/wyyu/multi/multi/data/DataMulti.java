package wyyu.multi.multi.data;

/**
 * Created by wyyu on 2019-09-29.
 **/

public class DataMulti {

    public String content;
    public int index;
    public int resId;

    public DataMulti(int index, int resId, String content) {
        this.index = index;
        this.resId = resId;
        this.content = content;
    }

    public @DataType int loadType() {
        return index % 3;
    }
}
