package com.skylarwatson.blinky.api;

import org.reflections.Reflections;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AnnotationLoader {
    public <T> List<BlinkerContext> load(T t, Class<? extends Annotation> annotation) {
        ConfigurationBuilder configurationBuilder = new ConfigurationBuilder();
        configurationBuilder.addUrls(ClasspathHelper.forClass(t.getClass()));

        return new ArrayList<>(new Reflections(configurationBuilder).getTypesAnnotatedWith(annotation)).stream().map(new Function<Class<?>, BlinkerContext>() {
            @Override
            public BlinkerContext apply(Class<?> klass) {
                BlinkerContext context = new BlinkerContext();
                context.setKlass(klass);
                return context;
            }
        }).collect(Collectors.toList());
    }
}
