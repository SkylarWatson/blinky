package com.skylarwatson.blinky.internal.command;

import com.skylarwatson.blinky.api.BlinkerContext;
import com.skylarwatson.blinky.api.config.LED;

public class CommandFactory {
    public BlinkCommand create(BlinkerContext context) {
        BlinkCommand blinkCommand = new BlinkCommand();
        blinkCommand.setData(new byte[] {
                0x01,
                (byte) 'c',
                context.getColor().getR(),
                context.getColor().getG(),
                context.getColor().getB(),
                (1 & 0xff),
                (1000 >> 8),
                LED.BOTH.value()
        });

        return blinkCommand;
    }
}
