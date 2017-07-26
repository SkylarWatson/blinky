package com.watson.blink.api;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AnnotationLoaderTest {
    private AnnotationLoader loader;

    @Before
    public void setup() {
        loader = new AnnotationLoader();
    }

    @Test
    public void returnsSizeOfZeroWhenNoClassesToLoad() {
        List<Class> classes = loader.load(this, TestAnnotation.class);

        assertThat(classes).isEmpty();
    }

    @Test
    public void foo() {
        List<Class> classes = loader.load(this, Blinker.class);

        assertThat(classes.get(0).getSimpleName()).isEqualTo("TestBlinker");
    }

    public @interface TestAnnotation {

    }

    @Blinker
    public class TestBlinker {

    }
}