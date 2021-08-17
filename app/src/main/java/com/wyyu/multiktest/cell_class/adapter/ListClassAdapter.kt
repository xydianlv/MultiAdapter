package com.wyyu.multiktest.cell_class.adapter

import androidx.recyclerview.widget.RecyclerView
import com.wyyu.multi.adapter.MultiAdapter
import com.wyyu.multi.cell.ICellManager

/**
 * Created by wyyu on 2021/7/30.
 **/

class ListClassAdapter<K, D>(
    cellManager: ICellManager<K, D>,
    recyclerView: RecyclerView
) : MultiAdapter<K, D>(cellManager, recyclerView) {

    fun initList(list: List<D>) {
        if (list.isEmpty()) {
            return
        }
        val itemList = getItemList()
        itemList.addAll(list)

        notifyItemRangeChanged(0, itemCount)
    }
}