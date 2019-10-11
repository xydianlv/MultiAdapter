package wyyu.multi.litho.data;

/**
 * Created by wyyu on 2019-10-11.
 **/

public class DataTest {

    public String content;
    public int index;
    public int resId;

    public DataTest(int index, int resId, String content) {
        this.index = index;
        this.resId = resId;
        this.content = content;
    }

    public @DataTypeT int loadType() {
        return index % 3;
    }
}
