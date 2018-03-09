package com.watson.blinky.api;

import com.watson.blinky.internal.command.CommandSender;

public class Illuminator {
    private CommandSender commandSender = new CommandSender();

    public void illuminate() {
        commandSender.send();
    }
}
