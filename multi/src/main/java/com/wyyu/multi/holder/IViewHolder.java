package com.wyyu.multi.holder;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import android.view.ViewGroup;

/**
 * Created by wyyu on 2019-09-27.
 **/

public interface IViewHolder {

    RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent);

    void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int index, @NonNull Object item);

    void bindViewHolderParams(@NonNull RecyclerView.ViewHolder holder, int index,
        @Nullable Object... params);

    void updateItem(@NonNull RecyclerView.ViewHolder viewHolder, int updateType, Object... params);
}
