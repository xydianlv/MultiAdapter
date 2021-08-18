package com.wyyu.multiktest.cell_Integer.adapter

import androidx.recyclerview.widget.RecyclerView
import com.wyyu.multi.adapter.MultiAdapter
import com.wyyu.multi.cell.AbsCellManager

class ListIntegerAdapter<K, D>(
    cellManager: AbsCellManager<K, D>,
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