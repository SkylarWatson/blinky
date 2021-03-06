package com.skylarwatson.blinky.api.config;

public enum LED {
    BOTH(0x00),
    TOP(0x01),
    BOTTOM(0x02);

    byte value;

    LED(int value) {
        this.value = (byte) value;
    }

    public byte value() {
        return value;
    }
}
