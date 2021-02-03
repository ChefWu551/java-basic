package com.yuefeng.annotation.annotations;

import jdk.nashorn.internal.ir.annotations.Reference;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface Aspect {

    Class<?>[] value();
}
