package com.wyyu.multi.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
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

public class MultiAdapter<T, V> extends RecyclerView.Adapter implements IAdapterMulti<T, V> {

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
    }

    @Override public int getItemViewType(int position) {
        return cellManager.getItemViewType(itemList.get(position));
    }

    @Override public int getItemCount() {
        return itemList == null ? 0 : itemList.size();
    }

    @Override public void register(@NonNull T keyValue, @NonNull IHolderCell holderCell) {
        cellManager.register(keyValue, holderCell);
    }

    @Override public void initItemList(List<V> itemList, boolean needClear) {
        if (itemList == null || itemList.isEmpty()) {
            return;
        }
        if (this.itemList == null) {
            this.itemList = new ArrayList<>();
        }
        if (needClear) {
            this.itemList.clear();
        }
        this.itemList.addAll(0, itemList);
        notifyDataSetChanged();
    }

    @Override public void appendItemList(List<V> itemList) {
        if (itemList == null || itemList.isEmpty()) {
            return;
        }
        if (this.itemList == null) {
            this.itemList = new ArrayList<>();
        }
        this.itemList.addAll(itemList);
        notifyDataSetChanged();
    }

    @Override public void insertItem(V item, int position) {
        if (item == null) {
            return;
        }
        if (this.itemList == null) {
            this.itemList = new ArrayList<>();
        }
        this.itemList.add(position, item);

        notifyItemInserted(position);
    }

    @Override public void removeItem(V item) {
        if (item == null || this.itemList == null || this.itemList.isEmpty()) {
            return;
        }
        int index = this.itemList.indexOf(item);

        this.itemList.remove(index);
        notifyItemRemoved(index);
    }

    @Override public void updateItem(@NonNull RecyclerView recyclerView, V item, int updateType) {
        if (item == null || this.itemList == null || this.itemList.isEmpty()) {
            return;
        }
        replaceItem(item);

        RecyclerView.ViewHolder viewHolder =
            recyclerView.findViewHolderForAdapterPosition(this.itemList.indexOf(item));
        if (viewHolder == null) {
            return;
        }
        cellManager.updateItem(viewHolder, item, updateType);
    }

    @Override
    public void updateItem(@NonNull RecyclerView recyclerView, int position, int updateType) {
        if (this.itemList == null || this.itemList.isEmpty()) {
            return;
        }
        if (position < 0 || position >= this.itemList.size()) {
            return;
        }
        V item = itemList.get(position);
        replaceItem(item);

        RecyclerView.ViewHolder viewHolder =
            recyclerView.findViewHolderForAdapterPosition(position);
        if (viewHolder == null) {
            return;
        }
        cellManager.updateItem(viewHolder, item, updateType);
    }

    @Override public void notifyItem(V item) {
        if (item == null || this.itemList == null || this.itemList.isEmpty()) {
            return;
        }
        replaceItem(item);
        notifyItemChanged(this.itemList.indexOf(item));
    }

    private void replaceItem(V item) {
        if (itemList == null || itemList.isEmpty()) {
            return;
        }
        int index = itemList.indexOf(item);
        itemList.remove(index);
        itemList.add(index, item);
    }
}
