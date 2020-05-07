package wyyu.multi.cell_integer.adapter;

import androidx.annotation.NonNull;
import com.wyyu.multi.adapter.MultiAdapter;
import com.wyyu.multi.cell.ICellManager;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wyyu on 2020-05-07.
 **/

public class AdapterListInteger<T, V> extends MultiAdapter<T, V> {

    public AdapterListInteger(@NonNull ICellManager<T, V> binderManager) {
        super(binderManager);
    }

    public void initList(List<V> dataList) {
        if (dataList == null || dataList.isEmpty()) {
            return;
        }
        List<V> itemList = getItemList();
        if (itemList == null) {
            itemList = new ArrayList<>();
        }
        itemList.clear();
        itemList.addAll(dataList);
        notifyDataSetChanged();
    }
}
