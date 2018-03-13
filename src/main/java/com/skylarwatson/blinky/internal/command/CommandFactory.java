package com.skylarwatson.blinky.internal.command;

import com.skylarwatson.blinky.api.BlinkerContext;

public class CommandFactory {
    private static byte HIGH_FADE_TIME = (1 & 0xff);
    private static byte LOW_FADE_TIME = (1000 >> 8);

    public BlinkCommand create(BlinkerContext context) {
        BlinkCommand blinkCommand = new BlinkCommand();
        blinkCommand.setData(new byte[] {
                0x01,
                (byte) 'c',
                context.getColor().getR(),
                context.getColor().getG(),
                context.getColor().getB(),
                HIGH_FADE_TIME,
                LOW_FADE_TIME,
                context.getLed().value()
        });

        return blinkCommand;
    }
}
