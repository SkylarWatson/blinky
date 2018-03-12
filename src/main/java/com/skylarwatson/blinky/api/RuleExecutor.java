package com.skylarwatson.blinky.api;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class RuleExecutor {
    public List<BlinkerContext> execute(List<BlinkerContext> contexts) {
        return contexts.stream().filter(context -> {
            try {
                return (Boolean) context.getKlass().getMethod("illuminate").invoke(context.getKlass().newInstance());
            } catch (Exception ignore) {
                ignore.printStackTrace();
            }
            return false;
        }).collect(toList());
    }
}