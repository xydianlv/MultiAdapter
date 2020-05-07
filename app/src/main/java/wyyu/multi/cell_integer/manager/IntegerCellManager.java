package wyyu.multi.cell_integer.manager;

import androidx.annotation.NonNull;
import com.wyyu.multi.cell.AbsCellManager;
import wyyu.multi.cell_integer.data.IIntegerData;

/**
 * Created by wyyu on 2020-05-07.
 **/

public class IntegerCellManager extends AbsCellManager<Integer, IIntegerData> {

    @Override public Integer[] loadKeyArray() {
        return new Integer[DEFAULT_LENGTH];
    }

    @Override public Integer loadKeyFromItem(@NonNull IIntegerData item) {
        return item.loadDataType();
    }
}
