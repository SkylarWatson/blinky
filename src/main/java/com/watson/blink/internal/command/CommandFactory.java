package com.watson.blink.internal.command;

public class CommandFactory {
    public BlinkCommand create() {
        BlinkCommand blinkCommand = new BlinkCommand();
        blinkCommand.setData(new byte[] {0x01, (byte) 'c', (byte) 155, (byte) 0, (byte) 0});

        return blinkCommand;
    }
}
