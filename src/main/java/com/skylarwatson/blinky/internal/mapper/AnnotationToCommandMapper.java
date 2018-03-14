package com.skylarwatson.blinky.internal.mapper;

import com.skylarwatson.blinky.api.Blinker;
import com.skylarwatson.blinky.api.command.BlinkCommand;

public class AnnotationToCommandMapper {
    public BlinkCommand map(Class<?> klass) {
        BlinkCommand command = new BlinkCommand();
        command.setLed(klass.getAnnotation(Blinker.class).led());
        command.setColor(klass.getAnnotation(Blinker.class).color());
        return command;
    }
}
