package com.wyyu.multi.holder;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import com.wyyu.multi.cell.IHolderCell;

/**
 * Created by wyyu on 2019-09-27.
 **/

public interface IViewHolder {

    RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent);

    IHolderCell findCellFromViewHolder(@NonNull RecyclerView.ViewHolder viewHolder);

    void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, @NonNull Object item);

    void bindViewHolderParams(@NonNull RecyclerView.ViewHolder holder, @Nullable Object... params);

    void updateItem(@NonNull RecyclerView.ViewHolder viewHolder, @NonNull Object item,
        int updateType, Object... params);
}
