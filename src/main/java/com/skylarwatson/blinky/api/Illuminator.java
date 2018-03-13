package com.skylarwatson.blinky.api;

import com.skylarwatson.blinky.internal.command.CommandFactory;
import com.skylarwatson.blinky.internal.command.CommandSender;

public class Illuminator {
    private CommandSender commandSender = new CommandSender();
    private CommandFactory factory = new CommandFactory();

    public void illuminate(BlinkerContext context) {
        commandSender.send(factory.create(context));
    }
}
