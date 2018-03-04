package com.watson.blink.api;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class RuleExecutor {
    public List<Class<?>> execute(List<Class<?>> classes) {
        return classes.stream().filter(klass -> {
            try {
                return (Boolean) klass.getMethod("illuminate").invoke(klass.newInstance());
            } catch (Exception ignore) {
                ignore.printStackTrace();
            }
            return false;
        }).collect(toList());
    }
}