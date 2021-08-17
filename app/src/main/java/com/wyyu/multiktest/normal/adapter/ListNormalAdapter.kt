package com.wyyu.multiktest.normal.adapter

import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import com.wyyu.multiktest.normal.holder.HolderNormalA
import android.view.LayoutInflater
import android.view.View
import com.wyyu.multiktest.R
import com.wyyu.multiktest.databinding.LayoutHolderNormalABinding
import com.wyyu.multiktest.databinding.LayoutHolderNormalBBinding
import com.wyyu.multiktest.normal.data.DataNormal
import com.wyyu.multiktest.normal.holder.HolderNormalB

/**
 * Created by wyyu on 2021/7/30.
 */

class ListNormalAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val dataList: ArrayList<DataNormal> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == 0) {
//            val view = View.inflate(parent.context,R.layout.layout_holder_normal_a,parent)
            HolderNormalA(LayoutHolderNormalABinding.inflate(LayoutInflater.from(parent.context)))
        } else {
            HolderNormalB(LayoutHolderNormalBBinding.inflate(LayoutInflater.from(parent.context)))
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is HolderNormalA) {
            holder.bindData(dataList[position])
        }
        if (holder is HolderNormalB) {
            holder.bindData(dataList[position])
        }
    }

    override fun getItemViewType(position: Int): Int {
        return position % 2
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    fun initList(list: ArrayList<DataNormal>?) {
        if (list == null || list.isEmpty()) {
            return
        }
        dataList.clear()
        dataList.addAll(list)

        notifyItemRangeChanged(0, itemCount)
    }
}