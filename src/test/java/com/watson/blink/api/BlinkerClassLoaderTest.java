package com.watson.blink.api;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class BlinkerClassLoaderTest {
    @Test
    public void returnsSizeOfZeroWhenNoClassesToLoad() {
        List<Class> classes = new BlinkerClassLoader().load(this, TestAnnotation.class);

        assertEquals(0, classes.size());
    }

    @Test
    public void foo() {
        List<Class> classes = new BlinkerClassLoader().load(this, Blinker.class);

        assertEquals("TestBlinker", classes.get(0).getSimpleName());
    }

    public @interface TestAnnotation {

    }

    @Blinker
    public class TestBlinker {

    }
}