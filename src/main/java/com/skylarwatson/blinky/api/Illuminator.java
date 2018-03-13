package com.skylarwatson.blinky.api;

import com.skylarwatson.blinky.api.config.RGB;
import com.skylarwatson.blinky.internal.command.CommandFactory;
import com.skylarwatson.blinky.internal.command.CommandSender;

public class Illuminator {
    private CommandSender commandSender = new CommandSender();
    private CommandFactory factory = new CommandFactory();

    public void illuminate(RGB rgb) {
        commandSender.send(factory.create(rgb));
    }

    public void illuminate(BlinkerContext context) {
        illuminate(context.getColor());
    }
}
