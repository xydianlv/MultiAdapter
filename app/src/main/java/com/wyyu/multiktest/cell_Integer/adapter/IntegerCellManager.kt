package com.wyyu.multiktest.cell_Integer.adapter

import com.wyyu.multi.cell.AbsCellManager
import com.wyyu.multiktest.cell_Integer.data.IDataInteger

class IntegerCellManager : AbsCellManager<Int, IDataInteger>() {

    override fun loadKeyFromData(itemData: IDataInteger): Int {
        return itemData.dataType()
    }
}