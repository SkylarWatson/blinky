package com.skylarwatson.blinky.api;

import com.skylarwatson.blinky.api.config.RGB;
import com.skylarwatson.blinky.internal.command.CommandFactory;
import com.skylarwatson.blinky.internal.command.CommandSender;

public class Illuminator {
    private CommandSender commandSender = new CommandSender();
    private CommandFactory factory = new CommandFactory();

    public void illuminate() {
        commandSender.send(factory.create(RGB.RED));
    }
}
