package wyyu.multi.cell_class.adapter;

import androidx.annotation.NonNull;
import com.wyyu.multi.adapter.MultiAdapter;
import com.wyyu.multi.cell.ICellManager;
import java.util.List;

/**
 * Created by wyyu on 2020-05-07.
 **/

public class AdapterListClass<T, V> extends MultiAdapter<T, V> {

    public AdapterListClass(@NonNull ICellManager<T, V> binderManager) {
        super(binderManager);
    }

    public void initList(List<V> objectList) {
        if (objectList == null || objectList.isEmpty()) {
            return;
        }
        List<V> dataList = getItemList();
        dataList.clear();
        dataList.addAll(objectList);
        notifyDataSetChanged();
    }
}
