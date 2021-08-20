package com.wyyu.multiktest.cell_Integer.holder

import android.view.View
import com.wyyu.expand.BindHolder
import com.wyyu.multi.cell.IHolderCell
import com.wyyu.multiktest.R
import com.wyyu.multiktest.cell_Integer.data.DataIntegerB
import com.wyyu.multiktest.databinding.LayoutHolderIntegerBBinding

@BindHolder
class HolderIntegerB : IHolderCell {

    private var binding: LayoutHolderIntegerBBinding? = null

    override fun getHolderLayout(): Int {
        return R.layout.layout_holder_integer_b
    }

    override fun onCreateView(itemView: View) {
        binding = LayoutHolderIntegerBBinding.bind(itemView)
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