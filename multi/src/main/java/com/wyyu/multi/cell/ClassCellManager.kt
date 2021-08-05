package com.wyyu.multi.cell

/**
 * Created by wyyu on 2021/7/29.
 **/

class ClassCellManager : AbsCellManager<Class<out Any>, Any>() {

    override fun loadKeyFromData(itemData: Any): Class<out Any> {
        return itemData::class.java
    }
}