package com.wyyu.multi.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wyyu.multi.cell.ICellManager
import com.wyyu.multi.cell.IHolderCell

/**
 * Created by wyyu on 2021/7/29.
 **/

open class MultiAdapter<K, D> constructor(
    private val cellManager: ICellManager<K, D>,
    private val recyclerView: RecyclerView
) : RecyclerView.Adapter<RecyclerView.ViewHolder>(), IMultiAdapter<K, D> {

    private var itemList: ArrayList<D> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return cellManager.onCreateViewHolder(parent, viewType)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        cellManager.onBindViewHolder(holder, position, itemList[position])
    }

    override fun getItemViewType(position: Int): Int {
        return cellManager.getItemViewType(itemList[position])
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun getItemList(): ArrayList<D> {
        return itemList
    }

    override fun updateItem(position: Int, updateType: Int, vararg params: Any?) {
        if (itemList.isEmpty()) {
            return
        }
        if (position < 0 || position >= itemList.size) {
            return
        }
        val viewHolder = recyclerView.findViewHolderForAdapterPosition(position)
        if (viewHolder != null) {
            cellManager.onUpdateItem(viewHolder, updateType, params)
        }
    }

    override fun registerItem(key: K, holderCell: IHolderCell) {
        cellManager.register(key, holderCell)
    }

    override fun registerNullItem(holderCell: IHolderCell) {
        cellManager.registerNullCell(holderCell)
    }

    override fun bindParams(vararg params: Any) {
        cellManager.bindParams(params)
    }
}