package com.skylarwatson.blinky.api;

import com.skylarwatson.blinky.api.config.RGB;

public class BlinkerContext {
    private Class<?> klass;
    private RGB color;

    public RGB getColor() {
        return color;
    }

    public void setColor(RGB color) {
        this.color = color;
    }

    public Class<?> getKlass() {
        return klass;
    }

    public void setKlass(Class<?> klass) {
        this.klass = klass;
    }
}
