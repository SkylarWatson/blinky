package com.skylarwatson.blinky.internal.command;

import com.skylarwatson.blinky.api.config.RGB;

public class CommandFactory {
    public BlinkCommand create(RGB rgb) {
        BlinkCommand blinkCommand = new BlinkCommand();
        blinkCommand.setData(new byte[] {0x01, (byte) 'c', rgb.getR(), rgb.getG(), rgb.getB()});

        return blinkCommand;
    }
}
