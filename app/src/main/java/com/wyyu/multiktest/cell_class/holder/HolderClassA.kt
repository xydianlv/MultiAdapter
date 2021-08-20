package com.wyyu.multiktest.cell_class.holder

import android.view.View
import com.wyyu.expand.BindHolder
import com.wyyu.multi.cell.IHolderCell
import com.wyyu.multiktest.R
import com.wyyu.multiktest.cell_class.data.DataClassA
import com.wyyu.multiktest.databinding.LayoutHolderClassABinding

/**
 * Created by wyyu on 2021/7/30.
 **/

@BindHolder
class HolderClassA : IHolderCell {

    private var binding: LayoutHolderClassABinding? = null

    override fun getHolderLayout(): Int {
        return R.layout.layout_holder_class_a
    }

    override fun onCreateView(itemView: View) {
        binding = LayoutHolderClassABinding.bind(itemView)
    }

    override fun onBindCell(position: Int, itemData: Any?, vararg params: Any?) {
        if (itemData !is DataClassA) {
            return
        }
        binding?.cellClassAIndex?.text = itemData.index.toString()
        binding?.cellClassAContent?.text = itemData.content
    }

    override fun onUpdateCell(updateType: Int, vararg params: Any?) {
    }
}