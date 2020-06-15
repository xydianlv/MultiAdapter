package com.wyyu.multi.cell;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
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
     * @param index 在列表中的位置
     * @param item 数据
     */
    void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int index, V item);

    /**
     * 在调用 onBindViewHolder 时，为 ViewHolder 设置扩展参数
     *
     * @param params 参数列表
     * @param index 在列表中的位置
     */
    void bindViewHolderParams(@NonNull RecyclerView.ViewHolder viewHolder, int index,
        @Nullable Object... params);

    /**
     * 根据新变更的数据局部刷新 ItemView
     *
     * @param holder 持有该数据的 ViewHolder
     * @param updateType 刷新类型，在 HolderBinder 中定制局部刷新方式
     * @param params 更新 Item 的扩展参数
     */
    void updateItem(@NonNull RecyclerView.ViewHolder holder, int updateType, Object... params);
}
