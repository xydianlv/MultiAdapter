package com.wyyu.multiktest.normal.holder

import androidx.recyclerview.widget.RecyclerView
import com.wyyu.multiktest.databinding.LayoutHolderNormalABinding
import com.wyyu.multiktest.normal.data.DataNormal

/**
 * Created by wyyu on 2021/7/30.
 */

class HolderNormalA(binding: LayoutHolderNormalABinding) : RecyclerView.ViewHolder(binding.root) {

    private var binding: LayoutHolderNormalABinding? = null

    init {
        this.binding = binding
    }

    fun bindData(data: DataNormal) {
        binding?.holderNormalAIndex?.text = data.index.toString()
        binding?.holderNormalAContent?.text = data.content
    }
}