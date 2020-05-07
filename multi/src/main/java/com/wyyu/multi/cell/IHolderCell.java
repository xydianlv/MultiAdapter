package com.wyyu.multi.cell;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * Created by wyyu on 2019-09-27.
 **/

public interface IHolderCell {

    void cacheCell(@NonNull Object item);

    void bindParams(@Nullable Object... params);

    void updateCell(int updateType, Object... params);
}
