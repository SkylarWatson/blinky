package com.skylarwatson.blinky.api.config;

public enum RGB {
    RED((byte) 155, (byte) 0, (byte) 0),
    GREEN((byte) 0, (byte) 128, (byte) 0);

    byte r, b, g;

    RGB(byte r, byte g, byte b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }
}
