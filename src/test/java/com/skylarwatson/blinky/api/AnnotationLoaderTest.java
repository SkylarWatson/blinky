package com.skylarwatson.blinky.api;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AnnotationLoaderTest {
    private AnnotationLoader loader;

    @Before
    public void setup() {
        loader = new AnnotationLoader();
    }

    @Test
    public void returnsSizeOfZeroWhenNoClassesToLoad() {
        assertThat(loader.load(this, TestAnnotation.class)).isEmpty();
    }

    @Test
    public void returnClassNameAnnotatedWithBlinkerAnnotation() {
        assertThat(loader.load(this, Blinker.class).get(0).getSimpleName()).isEqualTo("TestBlinker");
    }

    public @interface TestAnnotation {

    }

    @Blinker
    public class TestBlinker {

    }
}