package com.wyyu.multiktest.cell_Integer.holder

import com.wyyu.expand.BindHolder
import com.wyyu.multi.cell.IHolderCell
import com.wyyu.multiktest.cell_Integer.data.DataIntegerB
import com.wyyu.multiktest.databinding.LayoutHolderIntegerBBinding

@BindHolder("LayoutHolderIntegerBBinding")
class HolderIntegerB : IHolderCell {

    private var binding: LayoutHolderIntegerBBinding? = null

    override fun onCreateView(binding: Any) {
        if (binding is LayoutHolderIntegerBBinding) {
            this.binding = binding
        }
    }

    override fun onBindCell(position: Int, itemData: Any?, vararg params: Any?) {
        if (itemData !is DataIntegerB) {
            return
        }
        binding?.holderIntegerBIndex?.text = itemData.index.toString()
        binding?.holderIntegerBImage?.setImageResource(itemData.resId)
    }

    override fun onUpdateCell(updateType: Int, vararg params: Any?) {
    }
}