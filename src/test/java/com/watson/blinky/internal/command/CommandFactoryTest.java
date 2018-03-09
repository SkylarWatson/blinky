package com.watson.blinky.internal.command;

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
        assertThat(factory.create().getData()).isEqualTo(new byte[] {
                0x01,
                (byte) 'c',
                (byte) 155,
                (byte) 0,
                (byte) 0
        });
    }
}