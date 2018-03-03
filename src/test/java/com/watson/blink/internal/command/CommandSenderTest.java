package com.watson.blink.internal.command;

import com.watson.blink.internal.BlinkFinder;
import com.watson.blink.internal.factory.UsbControlIrpFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.usb.UsbDevice;
import javax.usb.UsbException;
import javax.usb.util.DefaultUsbControlIrp;

import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CommandSenderTest {
    @InjectMocks private CommandSender sender;
    @Mock UsbControlIrpFactory irpFactory;
    @Mock CommandFactory commandFactory;
    @Mock BlinkFinder finder;
    @Mock UsbDevice device;

    @Before
    public void setUp() {
        when(finder.find()).thenReturn(singletonList(device));
    }

    @Test
    public void commandSenderSubmitsIrpToDevice() throws UsbException {
        DefaultUsbControlIrp usbControlIrp = defaultUsbControllerIrp();

        when(irpFactory.create()).thenReturn(usbControlIrp);
        when(commandFactory.create()).thenReturn(new BlinkCommand());

        sender.send();

        verify(finder.find().get(0)).syncSubmit(usbControlIrp);
    }

    @Test
    public void commandDataIsSetOnIrp() throws UsbException {
        DefaultUsbControlIrp usbControlIrp = defaultUsbControllerIrp();
        BlinkCommand command = helloCommand();

        when(irpFactory.create()).thenReturn(usbControlIrp);
        when(commandFactory.create()).thenReturn(command);

        sender.send();

        assertThat(usbControlIrp.getData()).isEqualTo(command.getData());
    }

    private BlinkCommand helloCommand() {
        BlinkCommand command = new BlinkCommand();
        command.setData("Hello World!".getBytes());
        return command;
    }

    private DefaultUsbControlIrp defaultUsbControllerIrp() {
        return new DefaultUsbControlIrp((byte) 1, (byte) 2, (short) 1, (short) 2);
    }
}