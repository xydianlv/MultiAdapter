package com.wyyu.expand

/**
 * Created by wyyu on 2021/7/30.
 **/

@kotlin.annotation.Retention(AnnotationRetention.BINARY)
@kotlin.annotation.Target(AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.CLASS)
annotation class BindHolder(val value: String)