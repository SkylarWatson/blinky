package com.watson.blink.api;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class AnnotationLoaderTest {
    private AnnotationLoader loader;

    @Before
    public void setup() {
        loader = new AnnotationLoader();
    }

    @Test
    public void returnsSizeOfZeroWhenNoClassesToLoad() {
        List<Class> classes = loader.load(this, TestAnnotation.class);

        assertEquals(0, classes.size());
    }

    @Test
    public void foo() {
        List<Class> classes = loader.load(this, Blinker.class);

        assertEquals("TestBlinker", classes.get(0).getSimpleName());
    }

    public @interface TestAnnotation {

    }

    @Blinker
    public class TestBlinker {

    }
}