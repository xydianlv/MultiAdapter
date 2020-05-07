package com.wyyu.multi.cell;

import androidx.annotation.NonNull;

/**
 * Created by wyyu on 2019-09-27.
 *
 * 已列表中数据类型为唯一标识的 CellManager
 **/

public class ClassCellManager extends AbsCellManager<Class<?>, Object> {

    @Override public Class<?>[] loadKeyArray() {
        return new Class[DEFAULT_LENGTH];
    }

    @Override public Class<?> loadKeyFromItem(@NonNull Object item) {
        return item.getClass();
    }
}
