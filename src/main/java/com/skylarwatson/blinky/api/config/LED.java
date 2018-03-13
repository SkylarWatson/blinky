package com.skylarwatson.blinky.api.config;

public enum LED {
    BOTH(0x00);

    byte value;

    LED(int value) {
        this.value = (byte) value;
    }

    public byte value() {
        return value;
    }
}
