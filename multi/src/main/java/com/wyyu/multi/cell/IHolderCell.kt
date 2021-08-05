package com.wyyu.multi.cell

/**
 * Created by wyyu on 2021/7/29.
 **/

interface IHolderCell {

    fun onCreateView(binding: Any)

    fun onBindCell(position: Int, itemData: Any?, vararg params: Any?)

    fun onUpdateCell(updateType: Int, vararg params: Any?)
}