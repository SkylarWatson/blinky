package com.skylarwatson.blinky.api;

import com.skylarwatson.blinky.api.config.RGB;
import com.skylarwatson.blinky.internal.command.BlinkCommand;
import com.skylarwatson.blinky.internal.command.CommandFactory;
import com.skylarwatson.blinky.internal.command.CommandSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class IlluminatorTest {
    @InjectMocks private Illuminator illuminator;
    @Mock private CommandSender commandSender;
    @Mock private CommandFactory factory;

    @Test
    public void sendCommand() {
        BlinkCommand command = new BlinkCommand();

        when(factory.create(any(RGB.class))).thenReturn(command);

        illuminator.illuminate(RGB.RED);

        verify(commandSender).send(command);
    }

    @Test
    public void sendCommand_withRgbValuePassedIn() {
        illuminator.illuminate(RGB.GREEN);

        verify(factory).create(RGB.GREEN);
    }
}