package com.wyyu.multiktest.cell_class.holder

import com.wyyu.expand.BindHolder
import com.wyyu.multi.cell.IHolderCell
import com.wyyu.multiktest.databinding.LayoutHolderClassBBinding

/**
 * Created by wyyu on 2021/7/30.
 **/

@BindHolder("com.wyyu.multiktest.databinding.LayoutHolderClassBBinding")
class HolderClassB : IHolderCell {

    private var binding: LayoutHolderClassBBinding? = null

    override fun onCreateView(binding: Any) {
        if (binding is LayoutHolderClassBBinding) {
            this.binding = binding
        }
    }

    override fun onBindCell(position: Int, itemData: Any?, vararg params: Any?) {
    }

    override fun onUpdateCell(updateType: Int, vararg params: Any?) {
    }
}