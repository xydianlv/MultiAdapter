package com.wyyu.multi.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

/**
 * Created by wyyu on 2019-09-29.
 *
 * 约定刷新 Adapter 一个指定 Item 的方法
 **/

public interface IAdapterUpdate<V> {

    /**
     * 根据新变更的数据局部刷新 ItemView
     * 通过 RecyclerView 获取到待刷新的 ViewHolder，调用 BinderManager 中的 updateItem 方法，即可实现局部刷新
     *
     * @param recyclerView 用来获取 ViewHolder
     * @param item 变更后的数据
     * @param updateType 刷新类型，在 HolderBinder 中定制局部刷新方式
     */
    void updateItem(@NonNull RecyclerView recyclerView, V item, int updateType);

    /**
     * 根据新变更的数据局部刷新 ItemView
     *
     * @param recyclerView 用来获取 ViewHolder
     * @param position 发生变更的 Position
     * @param updateType 刷新类型，在 HolderBinder 中定制局部刷新方式
     */
    void updateItem(@NonNull RecyclerView recyclerView, int position, int updateType);

    /**
     * 更新整个 Item
     *
     * @param item 待更新的 Item
     */
    void notifyItem(V item);
}
