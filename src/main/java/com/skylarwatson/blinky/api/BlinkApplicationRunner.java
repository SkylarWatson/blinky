package com.skylarwatson.blinky.api;

import com.skylarwatson.blinky.api.config.RGB;

import java.util.List;

public class BlinkApplicationRunner {
    private AnnotationLoader annotationLoader = new AnnotationLoader();
    private Illuminator illuminator = new Illuminator();
    private RuleExecutor executor = new RuleExecutor();

    public void run() {
        List<BlinkerContext> result = executor.execute(annotationLoader.load(this, Blinker.class));

        if (!result.isEmpty()) {
            illuminator.illuminate(RGB.RED);
        }
    }
}
