package com.watson.blink.api;

import com.watson.blink.internal.command.CommandSender;

public class Illuminator {
    private CommandSender commandSender = new CommandSender();

    public void illuminate() {
        commandSender.send();
    }
}
