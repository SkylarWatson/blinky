package com.skylarwatson.blinky.api;

import com.skylarwatson.blinky.api.config.RGB;

import java.lang.annotation.Retention;

import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Blinker {
    String color() default RGB.RED;
}
