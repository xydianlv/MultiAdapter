package com.wyyu.multiktest.cell_Integer.holder

import android.view.View
import com.wyyu.expand.BindHolder
import com.wyyu.multi.cell.IHolderCell
import com.wyyu.multiktest.R
import com.wyyu.multiktest.cell_Integer.data.DataIntegerA
import com.wyyu.multiktest.databinding.LayoutHolderIntegerABinding

@BindHolder
class HolderIntegerA : IHolderCell {

    private var binding: LayoutHolderIntegerABinding? = null

    override fun getHolderLayout(): Int {
        return R.layout.layout_holder_integer_a
    }

    override fun onCreateView(itemView: View) {
        binding = LayoutHolderIntegerABinding.bind(itemView)
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