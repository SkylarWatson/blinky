package com.watson.blink.internal.command;

public class CommandFactory {
    public BlinkCommand create() {
        BlinkCommand blinkCommand = new BlinkCommand();
        blinkCommand.setData(new byte[] {0x01, (byte) 'n', (byte) 124, (byte) 252, 0});

        return blinkCommand;
    }
}
