package com.skylarwatson.blinky.internal.command;

import com.skylarwatson.blinky.api.config.RGB;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class CommandFactoryTest {
    @InjectMocks private CommandFactory factory;

    @Test
    public void createBlinkCommandToSetColorGreen() {
        assertThat(factory.create(RGB.RED).getData()).isEqualTo(new byte[] {
                0x01,
                (byte) 'c',
                (byte) 155,
                (byte) 0,
                (byte) 0
        });
    }
}