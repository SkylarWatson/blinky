package com.watson.blink.api;

import org.reflections.Reflections;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

public class BlinkerClassLoader {
    public <T> List<Class> load(T t, Class<? extends Annotation> annotation) {
        ConfigurationBuilder configurationBuilder = new ConfigurationBuilder();
        configurationBuilder.addUrls(ClasspathHelper.forClass(t.getClass()));

        return new ArrayList<>(new Reflections(configurationBuilder).getTypesAnnotatedWith(annotation));
    }
}
