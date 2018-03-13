package com.skylarwatson.blinky.internal.command;

import com.skylarwatson.blinky.api.config.LED;
import com.skylarwatson.blinky.api.config.RGB;

public class CommandFactory {
    public BlinkCommand create(RGB rgb) {
        BlinkCommand blinkCommand = new BlinkCommand();
        blinkCommand.setData(new byte[] {0x01, (byte) 'c', rgb.getR(), rgb.getG(), rgb.getB(), (1 & 0xff), (1000 >> 8), LED.BOTH.value()});

        return blinkCommand;
    }
}
