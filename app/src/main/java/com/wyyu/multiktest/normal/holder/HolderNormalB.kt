package com.wyyu.multiktest.normal.holder

import androidx.recyclerview.widget.RecyclerView
import com.wyyu.multiktest.databinding.LayoutHolderNormalBBinding
import com.wyyu.multiktest.normal.data.DataNormal

class HolderNormalB(binding: LayoutHolderNormalBBinding) : RecyclerView.ViewHolder(binding.root) {

    private var binding: LayoutHolderNormalBBinding? = null

    init {
        this.binding = binding
    }

    fun bindData(data: DataNormal) {
        binding?.holderNormalBIndex?.text = data.index.toString()
        binding?.holderNormalBImage?.setImageResource(data.resId)
    }
}