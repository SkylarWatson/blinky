package com.skylarwatson.blinky.api;

import java.util.List;

public class BlinkApplicationRunner {
    private AnnotationLoader annotationLoader = new AnnotationLoader();
    private Illuminator illuminator = new Illuminator();
    private RuleExecutor executor = new RuleExecutor();

    public void run() {
        List result = executor.execute(annotationLoader.load(this, Blinker.class));

        if (!result.isEmpty()) {
            illuminator.illuminate();
        }
    }
}
