package com.skylarwatson.blinky.api;

import org.reflections.Reflections;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AnnotationLoader {
    public <T> List<BlinkerContext> load(T t, Class<? extends Annotation> annotation) {
        ConfigurationBuilder builder = new ConfigurationBuilder();
        builder.addUrls(ClasspathHelper.forClass(t.getClass()));

        return new ArrayList<>(new Reflections(builder).getTypesAnnotatedWith(annotation)).stream().map(klass -> {
            BlinkerContext context = new BlinkerContext();
            context.setKlass(klass);
            context.setColor(klass.getAnnotation(Blinker.class).color());
            context.setLed(klass.getAnnotation(Blinker.class).led());
            return context;
        }).collect(Collectors.toList());
    }
}
