package com.wyyu.multiktest.cell_class.holder

import com.wyyu.expand.BindHolder
import com.wyyu.multi.cell.IHolderCell
import com.wyyu.multiktest.cell_class.data.DataClassB
import com.wyyu.multiktest.databinding.LayoutHolderClassBBinding

/**
 * Created by wyyu on 2021/7/30.
 **/

@BindHolder("LayoutHolderClassBBinding")
class HolderClassB : IHolderCell {

    private var binding: LayoutHolderClassBBinding? = null

    override fun onCreateView(binding: Any) {
        if (binding is LayoutHolderClassBBinding) {
            this.binding = binding
        }
    }

    override fun onBindCell(position: Int, itemData: Any?, vararg params: Any?) {
        if (itemData !is DataClassB) {
            return
        }
        binding?.cellClassBIndex?.text = itemData.index.toString()
        binding?.cellClassBImage?.setImageResource(itemData.resId)
    }

    override fun onUpdateCell(updateType: Int, vararg params: Any?) {
    }
}