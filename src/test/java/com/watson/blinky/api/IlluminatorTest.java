package com.watson.blinky.api;

import com.watson.blinky.internal.command.CommandSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class IlluminatorTest {
    @InjectMocks private Illuminator illuminator;
    @Mock private CommandSender commandSender;

    @Test
    public void sendCommand() {
        illuminator.illuminate();

        verify(commandSender).send();
    }
}