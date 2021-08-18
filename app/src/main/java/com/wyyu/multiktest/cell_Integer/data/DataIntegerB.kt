package com.wyyu.multiktest.cell_Integer.data

import com.wyyu.multiktest.app.Constants

class DataIntegerB(
    val index: Int,
    val resId: Int = Constants.RES_ID,
    val content: String = Constants.CONTENT
) : IDataInteger {

    override fun dataType(): Int {
        return IDataInteger.DATA_B
    }
}