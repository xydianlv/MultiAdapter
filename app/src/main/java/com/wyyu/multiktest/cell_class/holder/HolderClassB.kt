package com.wyyu.multiktest.cell_class.holder

import android.view.View
import com.wyyu.expand.BindHolder
import com.wyyu.multi.cell.IHolderCell
import com.wyyu.multiktest.R
import com.wyyu.multiktest.cell_class.data.DataClassB
import com.wyyu.multiktest.databinding.LayoutHolderClassBBinding

/**
 * Created by wyyu on 2021/7/30.
 **/

@BindHolder
class HolderClassB : IHolderCell {

    private var binding: LayoutHolderClassBBinding? = null

    override fun getHolderLayout(): Int {
        return R.layout.layout_holder_class_b
    }

    override fun onCreateView(itemView: View) {
        binding = LayoutHolderClassBBinding.bind(itemView)
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