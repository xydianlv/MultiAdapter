package com.wyyu.multiktest.cell_Integer.holder

import com.wyyu.expand.BindHolder
import com.wyyu.multi.cell.IHolderCell
import com.wyyu.multiktest.cell_Integer.data.DataIntegerA
import com.wyyu.multiktest.databinding.LayoutHolderIntegerABinding

@BindHolder("LayoutHolderIntegerABinding")
class HolderIntegerA : IHolderCell {

    private var binding: LayoutHolderIntegerABinding? = null

    override fun onCreateView(binding: Any) {
        if (binding is LayoutHolderIntegerABinding) {
            this.binding = binding
        }
    }

    override fun onBindCell(position: Int, itemData: Any?, vararg params: Any?) {
        if (itemData !is DataIntegerA) {
            return
        }
        binding?.holderIntegerAIndex?.text = itemData.index.toString()
        binding?.holderIntegerAContent?.text = itemData.content
    }

    override fun onUpdateCell(updateType: Int, vararg params: Any?) {
    }
}