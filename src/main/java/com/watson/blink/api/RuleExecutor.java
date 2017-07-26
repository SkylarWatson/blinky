package com.watson.blink.api;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class RuleExecutor {
    public <T extends BlinkRule> List<Class<? extends BlinkRule>> execute(List<Class<? extends BlinkRule>> classes) {
        return classes.stream().filter(klass -> {
            try {
                return (Boolean) klass.getMethod("shouldRun").invoke(klass.newInstance());
            } catch (Exception ignore) {
                ignore.printStackTrace();
            }
            return false;
        }).collect(toList());
    }
}