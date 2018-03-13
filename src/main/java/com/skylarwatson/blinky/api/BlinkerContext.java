package com.skylarwatson.blinky.api;

import com.skylarwatson.blinky.api.config.LED;
import com.skylarwatson.blinky.api.config.RGB;

public class BlinkerContext {
    private Class<?> klass;
    private RGB color;
    private LED led;

    public LED getLed() {
        return led;
    }

    public void setLed(LED led) {
        this.led = led;
    }

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
