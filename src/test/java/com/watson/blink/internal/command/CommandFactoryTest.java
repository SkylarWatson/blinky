package com.watson.blink.internal.command;

import com.watson.blink.internal.command.CommandFactory;
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
                (byte) 'n',
                (byte) 124,
                (byte) 252,
                0
        });
    }
}