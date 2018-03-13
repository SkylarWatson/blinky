package com.skylarwatson.blinky.api.config;

public enum RGB {
    RED((byte) 155, (byte) 0, (byte) 0),
    GREEN((byte) 0, (byte) 128, (byte) 0),
    BLUE((byte) 0, (byte) 0, (byte) 255),
    WHITE((byte) 255, (byte) 255, (byte) 255),
    YELLOW((byte) 255, (byte) 255, (byte) 0),
    OFF((byte) 0, (byte) 0, (byte) 0);

    byte r, b, g;

    RGB(byte r, byte g, byte b) {
        this.r = r;
        this.g = g;
        this.b = b;
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
