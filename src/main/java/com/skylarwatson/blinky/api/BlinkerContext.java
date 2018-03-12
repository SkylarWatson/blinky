package com.skylarwatson.blinky.api;

public class BlinkerContext {
    private Class<?> klass;
    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Class<?> getKlass() {
        return klass;
    }

    public void setKlass(Class<?> klass) {
        this.klass = klass;
    }
}
