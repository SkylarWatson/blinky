package com.skylarwatson.blinky.api;

import com.skylarwatson.blinky.api.config.RGB;
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
        assertThat(loader.load(this, Blinker.class).get(0).getKlass().getSimpleName()).isEqualTo("TestBlinker");
    }

    @Test
    public void returnColorForAnnotatedClass() {
        assertThat(loader.load(this, Blinker.class).get(0).getColor()).isEqualTo(RGB.GREEN);
    }

    public @interface TestAnnotation {

    }

    @Blinker(color = RGB.GREEN)
    public class TestBlinker {

    }
}