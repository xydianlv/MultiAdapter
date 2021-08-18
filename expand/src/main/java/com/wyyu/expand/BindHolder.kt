package com.wyyu.expand

/**
 * Created by wyyu on 2021/7/30.
 **/

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.BINARY)
annotation class BindHolder(val value: String)