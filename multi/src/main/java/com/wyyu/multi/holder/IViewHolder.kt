package com.wyyu.multi.holder

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by wyyu on 2021/7/29.
 **/

interface IViewHolder {

    fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder

    fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int, itemData: Any?, vararg params: Any?)

    fun onUpdateViewHolder(holder: RecyclerView.ViewHolder, updateType: Int, vararg params: Any?)
}