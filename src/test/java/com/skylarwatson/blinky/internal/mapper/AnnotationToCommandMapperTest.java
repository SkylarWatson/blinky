package com.skylarwatson.blinky.internal.mapper;

import com.skylarwatson.blinky.api.config.LED;
import com.skylarwatson.blinky.api.config.RGB;
import com.skylarwatson.blinky.internal.TestBlinker;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AnnotationToCommandMapperTest {
    private AnnotationToCommandMapper mapper;

    @Before
    public void setUp() {
        mapper = new AnnotationToCommandMapper();
    }

    @Test
    public void map_set_led_on_command() {
        TestBlinker blinker = new TestBlinker();

        assertThat(mapper.map(blinker.getClass()).getLed()).isEqualTo(LED.TOP);
    }

    @Test
    public void map_set_color_on_command() {
        TestBlinker blinker = new TestBlinker();

        assertThat(mapper.map(blinker.getClass()).getColor()).isEqualTo(RGB.GREEN);
    }
}