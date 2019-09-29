package com.wyyu.multi.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import com.wyyu.multi.cell.IHolderCell;
import java.util.List;

/**
 * Created by wyyu on 2019-09-27.
 *
 * 约定该 Adapter 具有的最基本的一些功能
 *
 * register ： 注册 Holder类型 到 Adapter
 *
 * initItemList、appendItemList、insertItem、removeItem ： 列表的 增、删 操作
 *
 * updateItem、notifyItem ： 刷新 Item
 **/

public interface IAdapterMulti<T, V> {

    /**
     * 注册一种 Holder 类型到 Adapter
     *
     * @param keyValue 可唯一标识一种 Holder 类型的 数据对象
     * @param holderCell 构造该 Holder 的 HolderBinder
     */
    void register(@NonNull T keyValue, @NonNull IHolderCell holderCell);

    /**
     * 初始化列表
     *
     * @param itemList 初始化列表数据
     * @param needClear 是否需要清空列表，true —— 清空列表重新填充，false —— 将这一组数据插入到列表头
     */
    void initItemList(List<V> itemList, boolean needClear);

    /**
     * 添加一组数据到列表尾部
     *
     * @param itemList 待添加数据
     */
    void appendItemList(List<V> itemList);

    /**
     * 插入一个数据到指定位置
     *
     * @param item 待插入数据
     * @param position 指定位置
     */
    void insertItem(V item, int position);

    /**
     * 移除列表中指定数据
     *
     * @param item 待移除数据
     */
    void removeItem(V item);

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
