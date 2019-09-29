package wyyu.multi.multi;

import android.support.annotation.NonNull;
import com.wyyu.multi.cell.AbsCellManager;
import wyyu.multi.multi.data.DataMulti;

/**
 * Created by wyyu on 2019-09-29.
 **/

public class IntegerCellManager extends AbsCellManager<Integer, DataMulti> {

    @Override public Integer[] loadKeyArray() {
        return new Integer[DEFAULT_LENGTH];
    }

    @Override public Integer loadKeyFromItem(@NonNull DataMulti item) {
        return item.loadType();
    }
}
