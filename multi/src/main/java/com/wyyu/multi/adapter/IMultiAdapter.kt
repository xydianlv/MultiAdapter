package com.wyyu.multi.adapter

import com.wyyu.multi.cell.IHolderCell

/**
 * Created by wyyu on 2021/7/29.
 **/

interface IMultiAdapter<K, D> {

    fun getItemList(): ArrayList<D>

    fun updateItem(position: Int, updateType: Int, vararg params: Any?)

    fun registerItem(key: K, holderCell: IHolderCell)

    fun registerNullItem(holderCell: IHolderCell)

    fun bindParams(vararg params: Any)
}