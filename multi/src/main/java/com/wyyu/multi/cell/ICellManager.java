package com.wyyu.multi.cell;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

/**
 * Created by wyyu on 2019-09-27.
 **/

public interface ICellManager<T, V> {

    /**
     * 初始化一个自定义标识的 KeyArray
     *
     * @return 返回构建的 KeyArray
     */
    T[] loadKeyArray();

    /**
     * 注册一种 Holder 类型到 Adapter
     *
     * @param keyValue 可唯一标识一种 Holder 类型的一种对象数据
     * @param holderCell 构造该 Holder 的 HolderBinder
     */
    void register(@NonNull T keyValue, @NonNull IHolderCell holderCell);

    /**
     * 获取当前数据对应的 ViewType
     *
     * @param item 数据结构
     * @return ViewType
     */
    int getItemViewType(@NonNull V item);

    /**
     * 从拿到的 item 数据结构中返回该 item 对应的 Holder 类型
     *
     * @param item 数据结构
     * @return Holder 类型
     */
    T loadKeyFromItem(@NonNull V item);

    /**
     * 根据 ViewType 创建相应的 ViewHolder
     *
     * @param parent 父布局
     * @param viewType Holder 类型
     * @return ViewHolder
     */
    @NonNull RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType);

    /**
     * 绑定数据到 ViewHolder
     *
     * @param holder ViewHolder
     * @param item 数据
     */
    void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, V item);

    /**
     * 根据新变更的数据局部刷新 ItemView
     *
     * @param holder 持有该数据的 ViewHolder
     * @param item 变更后的数据
     * @param updateType 刷新类型，在 HolderBinder 中定制局部刷新方式
     */
    void updateItem(@NonNull RecyclerView.ViewHolder holder, V item, int updateType);
}
