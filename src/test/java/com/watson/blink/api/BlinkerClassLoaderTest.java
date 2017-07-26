package com.watson.blink.api;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class BlinkerClassLoaderTest {
    @Test
    public void returnsSizeOfZeroWhenNoClassesToLoad() {
        List<Class> classes = new BlinkerClassLoader().load();

        assertEquals(0, classes.size());
    }
}