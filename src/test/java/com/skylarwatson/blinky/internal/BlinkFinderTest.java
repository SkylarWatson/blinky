package com.skylarwatson.blinky.internal;

import com.skylarwatson.blinky.internal.factory.UsbHubFactory;
import com.skylarwatson.blinky.api.RuleExecutor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.usb.UsbDevice;
import javax.usb.UsbDeviceDescriptor;
import javax.usb.UsbHub;

import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BlinkFinderTest {
    @InjectMocks BlinkFinder finder;

    @Mock private UsbDeviceDescriptor descriptor;
    @Mock private UsbDevice device;
    @Mock private UsbHub hub;
    @Mock private RuleExecutor executor;
    @Mock private UsbHubFactory factory;

    @Test
    public void noDevicesReturnedWhenProductIdDoesntMatch() {
        when(factory.create()).thenReturn(singletonList(device));

        when(device.getUsbDeviceDescriptor()).thenReturn(descriptor);
        when(descriptor.idProduct()).thenReturn((short) 0x0000);

        assertThat(finder.find()).isEmpty();
    }

    @Test
    public void deviceIsReturnedWhenProductMatches() {
        when(factory.create()).thenReturn(singletonList(device));
        when(device.getUsbDeviceDescriptor()).thenReturn(descriptor);

        when(descriptor.idProduct()).thenReturn((short) 0x01ed);

        assertThat(finder.find()).containsOnly(device);
    }
}