package com.wyyu.multi.cell

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by wyyu on 2021/7/29.
 **/

interface ICellManager<K, D> {

    fun loadKeyFromData(itemData: D): K

    fun getItemViewType(itemData: D): Int

    fun register(key: K, holderCell: IHolderCell)

    fun bindParams(vararg params: Any?)

    fun registerNullCell(holderCell: IHolderCell)

    fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder

    fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int, itemData: D)

    fun onUpdateItem(holder: RecyclerView.ViewHolder, type: Int, vararg params: Any?)
}