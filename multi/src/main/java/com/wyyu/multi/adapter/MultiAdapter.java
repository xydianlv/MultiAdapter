package com.wyyu.multi.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.ViewGroup;
import com.wyyu.multi.cell.ICellManager;
import com.wyyu.multi.cell.IHolderCell;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wyyu on 2019-09-27.
 *
 * 一个可对 ViewHolder 自动进行分配的 Adapter
 *
 * 提供 增、删、改 操作
 *
 * 若现有的无法满足当前需求，可继承该 Adapter 根据需求定制方法
 **/

public class MultiAdapter<T, V> extends RecyclerView.Adapter<RecyclerView.ViewHolder>
    implements IAdapterMulti<T, V> {

    private ICellManager<T, V> cellManager;
    private List<V> itemList;

    public MultiAdapter(@NonNull ICellManager<T, V> binderManager) {
        this.cellManager = binderManager;
        this.itemList = new ArrayList<>();
    }

    @NonNull @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return cellManager.onCreateViewHolder(viewGroup, i);
    }

    @Override public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        cellManager.onBindViewHolder(viewHolder, itemList.get(i));
        cellManager.bindViewHolderParams(viewHolder, getBindParams());
    }

    @Override public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position,
        @NonNull List<Object> payloads) {
        if (payloads.isEmpty()) {
            onBindViewHolder(holder, position);
            return;
        }
        for (Object object : payloads) {
            if (!(object instanceof UpdateStruct)) {
                continue;
            }
            UpdateStruct struct = (UpdateStruct) object;
            cellManager.updateItem(holder, struct.updateType, struct.params);
        }
    }

    @Override public int getItemViewType(int position) {
        return cellManager.getItemViewType(itemList.get(position));
    }

    @Override public int getItemCount() {
        return itemList == null ? 0 : itemList.size();
    }

    @Override public Object[] getBindParams() {
        return new Object[0];
    }

    @Override public List<V> getItemList() {
        return itemList;
    }

    @Override public void register(@NonNull T keyValue, @NonNull IHolderCell holderCell) {
        cellManager.register(keyValue, holderCell);
    }

    @Override public void updateItem(int position, int updateType, Object... params) {
        if (itemList == null || itemList.isEmpty()) {
            return;
        }
        if (position < 0 || position >= itemList.size()) {
            return;
        }
        notifyItemChanged(position, new UpdateStruct(updateType, params));
    }
}
