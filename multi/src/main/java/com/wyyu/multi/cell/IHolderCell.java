package com.wyyu.multi.cell;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by wyyu on 2019-09-27.
 **/

public interface IHolderCell {

    void cacheCell(@NonNull Object item);

    void bindParams(@Nullable Object... params);

    void updateCell(@NonNull Object item, int updateType, Object... params);
}
