package com.wyyu.multi.holder

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by wyyu on 2021/7/29.
 **/

class EmptyViewHolder : IViewHolder {

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val emptyView = View(parent.context)
        emptyView.layoutParams = ViewGroup.LayoutParams(0, 0)
        return ViewHolder(emptyView)
    }

    override fun onBindViewHolder(
        holder: RecyclerView.ViewHolder,
        position: Int,
        itemData: Any?,
        vararg params: Any?
    ) {
    }

    override fun onUpdateViewHolder(
        holder: RecyclerView.ViewHolder,
        updateType: Int,
        vararg params: Any?
    ) {
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}