package com.wyyu.multi.adapter;

import androidx.annotation.NonNull;
import com.wyyu.multi.cell.IHolderCell;
import java.util.List;

/**
 * Created by wyyu on 2019-09-27.
 *
 * 约定该 Adapter 具有的最基本的一些功能
 *
 * getBindParams ： 向实现了 IHolderCell 的卡片在 onBind 时提供扩展数据
 *
 * getItemList ： 获取 MultiAdapter 当前持有的数据列表
 *
 * register ： 注册实现了 IHolderCell 的卡片到 MultiAdapter
 *
 * updateItem ： 通过 updateType 刷新指定 Item 的局部区域
 *
 * MultiAdapter 中已实现的方法无法满足需求时，可新建一个子类继承 MultiAdapter，再编写符合需求的方法或变量
 **/

public interface IAdapterMulti<T, V> {

    /**
     * 获取在调用 onBindViewHolder 时，需要向 ViewHolder 传入的扩展参数列表
     *
     * @return 参数列表
     */
    Object[] getBindParams();

    /**
     * 获取 Adapter 中当前持有的数据列表
     *
     * @return 数据列表
     */
    List<V> getItemList();

    /**
     * 注册一种 Holder 类型到 Adapter
     *
     * @param keyValue 可唯一标识一种 Holder 类型的 数据对象
     * @param holderCell 构造该 Holder 的 HolderBinder
     */
    void register(@NonNull T keyValue, @NonNull IHolderCell holderCell);

    /**
     * 根据新变更的数据局部刷新 ItemView
     *
     * @param position 发生变更的 Position
     * @param updateType 刷新类型，在 HolderBinder 中定制局部刷新方式
     * @param params 更新 Item 的扩展参数
     */
    void updateItem(int position, int updateType, Object... params);
}
