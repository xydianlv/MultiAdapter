package com.wyyu.multi.cell;

import android.support.annotation.NonNull;

/**
 * Created by wyyu on 2019-09-27.
 **/

public interface IHolderCell {

    void cacheCell(@NonNull Object item);

    void updateCell(@NonNull Object item, int updateType);
}
