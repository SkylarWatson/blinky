package com.skylarwatson.blinky.internal.command;

import com.skylarwatson.blinky.api.BlinkerContext;
import com.skylarwatson.blinky.api.config.LED;
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
        BlinkerContext context = new BlinkerContext();
        context.setColor(RGB.RED);
        context.setLed(LED.TOP);

        assertThat(factory.create(context).getData()).isEqualTo(new byte[] {
                0x01,
                (byte) 'c',
                (byte) 155,
                (byte) 0,
                (byte) 0,
                (1 & 0xff),
                (1000 >> 8),
                LED.TOP.value()
        });
    }
}