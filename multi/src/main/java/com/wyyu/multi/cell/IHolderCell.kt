package com.wyyu.multi.cell

import android.view.View
import androidx.annotation.LayoutRes

/**
 * Created by wyyu on 2021/7/29.
 **/

interface IHolderCell {

    @LayoutRes
    fun getHolderLayout(): Int

    fun onCreateView(itemView: View)

    fun onBindCell(position: Int, itemData: Any?, vararg params: Any?)

    fun onUpdateCell(updateType: Int, vararg params: Any?)
}