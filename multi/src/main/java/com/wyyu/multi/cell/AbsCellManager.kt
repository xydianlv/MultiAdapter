package com.wyyu.multi.cell

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wyyu.multi.holder.EmptyViewHolder
import com.wyyu.multi.holder.IViewHolder
import java.lang.Exception

/**
 * Created by wyyu on 2021/7/29.
 **/

abstract class AbsCellManager<K, D> : ICellManager<K, D> {

    private var holderMap: HashMap<Int, IViewHolder?> = HashMap()
    private var keyArray: ArrayList<K> = ArrayList()

    private var params: Array<out Any?> = arrayOfNulls(0)
    private var nullHolder: IViewHolder? = null

    private fun loadHolderFromCell(holderCell: IHolderCell): IViewHolder? {
        try {
            val holderName = loadHolderName(holderCell)
            if (holderName == null || holderName.isEmpty()) {
                return null
            }
            val holderClass = Class.forName(holderName)
            return holderClass.newInstance() as IViewHolder
        } catch (e: Exception) {
            return null
        }
    }

    private fun loadHolderName(holderCell: IHolderCell): String? {
        if (holderCell::class.java.`package` == null) {
            return null
        }
        val packageName = holderCell::class.java.`package`!!.name
        val mid = ".Holder"
        val className = holderCell::class.java.name
        val nameNext = className.substring(className.lastIndexOf(".") + 1)

        return packageName + mid + nameNext
    }

    override fun register(key: K, holderCell: IHolderCell) {
        keyArray.add(key)
        holderMap[keyArray.indexOf(key)] = loadHolderFromCell(holderCell)
    }

    override fun registerNullCell(holderCell: IHolderCell) {
        nullHolder = loadHolderFromCell(holderCell)
    }

    override fun bindParams(vararg params: Any?) {
        this.params = params
    }

    override fun getItemViewType(itemData: D): Int {
        if (keyArray.isEmpty()) {
            throw IllegalArgumentException("The Item = " + itemData!!::class.java.name + " Not Register To Adapter")
        }
        val key = loadKeyFromData(itemData)
        if (keyArray.contains(key)) {
            return keyArray.indexOf(key)
        }
        throw IllegalArgumentException("The Item = " + itemData!!::class.java.name + " Not Register To Adapter")
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var viewHolder = holderMap[viewType]?.onCreateViewHolder(parent)
        if (viewHolder == null) {
            viewHolder = nullHolder?.onCreateViewHolder(parent)
        }
        if (viewHolder == null) {
            viewHolder = EmptyViewHolder().onCreateViewHolder(parent)
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int, itemData: D) {
        holderMap[holder.itemViewType]?.onBindViewHolder(holder, position, itemData, params)
    }

    override fun onUpdateItem(holder: RecyclerView.ViewHolder, type: Int, vararg params: Any?) {
        holderMap[holder.itemViewType]?.onUpdateViewHolder(holder, type, params)
    }
}