package com.wyyu.expand;

import android.support.annotation.LayoutRes;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by wyyu on 2019-09-27.
 **/

@Retention(RetentionPolicy.CLASS)
@Target(ElementType.TYPE)
public @interface BindCell {

    @LayoutRes
    int value();
}
