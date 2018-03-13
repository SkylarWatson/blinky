package com.skylarwatson.blinky.api.config;

public enum RGB {
    RED(155, 0, 0),
    GREEN(0, 128, 0),
    BLUE(0, 0, 255),
    WHITE(255, 255, 255),
    YELLOW(255, 255, 0),
    ORANGE(204, 102, 0),
    OFF(0, 0, 0);

    byte r, b, g;

    RGB(int r, int g, int b) {
        this.r = (byte) r;
        this.g = (byte) g;
        this.b = (byte) b;
    }

    public byte getR() {
        return r;
    }

    public byte getB() {
        return b;
    }

    public byte getG() {
        return g;
    }
}
