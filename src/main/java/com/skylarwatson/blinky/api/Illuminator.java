package com.skylarwatson.blinky.api;

import com.skylarwatson.blinky.internal.command.CommandSender;

public class Illuminator {
    private CommandSender commandSender = new CommandSender();

    public void illuminate() {
        commandSender.send();
    }
}
