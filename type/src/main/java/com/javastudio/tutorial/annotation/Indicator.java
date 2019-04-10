package com.javastudio.tutorial.annotation;

import com.javastudio.tutorial.type.EntityIndicator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Indicator {

    EntityIndicator name();
}
