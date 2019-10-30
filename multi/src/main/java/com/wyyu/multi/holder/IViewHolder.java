package com.wyyu.multi.holder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

/**
 * Created by wyyu on 2019-09-27.
 **/

public interface IViewHolder {

    RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent);

    void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, @NonNull Object item);

    void updateItem(@NonNull RecyclerView.ViewHolder viewHolder, @NonNull Object item,
        int updateType, Object... params);
}
