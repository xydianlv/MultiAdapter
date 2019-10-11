package wyyu.multi.litho;

import android.support.annotation.NonNull;
import com.wyyu.multi.cell.AbsCellManager;
import wyyu.multi.litho.data.DataTest;

/**
 * Created by wyyu on 2019-10-11.
 **/

public class DataCellManager extends AbsCellManager<Integer, DataTest> {

    @Override public Integer[] loadKeyArray() {
        return new Integer[DEFAULT_LENGTH];
    }

    @Override public Integer loadKeyFromItem(@NonNull DataTest item) {
        return item.loadType();
    }
}