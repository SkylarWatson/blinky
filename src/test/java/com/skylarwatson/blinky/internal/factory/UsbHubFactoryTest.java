package com.skylarwatson.blinky.internal.factory;

import com.skylarwatson.blinky.internal.UsbHostManagerAdapter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.usb.UsbDevice;
import javax.usb.UsbHub;
import javax.usb.UsbPort;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UsbHubFactoryTest {
    @InjectMocks private UsbHubFactory factory;
    @Mock private UsbHostManagerAdapter adapter;
    @Mock private UsbPort usbPort;
    @Mock private UsbHub usbHub;
    @Mock private List<UsbDevice> devices;

    @Test
    public void returnEmptyListWhenNoDevicesFound() {
        when(adapter.getUsbPorts()).thenReturn(new ArrayList<>());

        assertThat(factory.create()).isEmpty();
    }

    @Test
    public void returnDevicesFoundOnUsbHub() {
        List<UsbDevice> devices = asList(mock(UsbDevice.class), mock(UsbDevice.class));

        when(adapter.getUsbPorts()).thenReturn(Collections.singletonList(usbPort));
        when(usbPort.getUsbDevice()).thenReturn(usbHub);
        when(usbHub.isUsbHub()).thenReturn(true);
        when(usbHub.getAttachedUsbDevices()).thenReturn(devices);

        assertThat(factory.create().size()).isEqualTo(2);
    }

    @Test
    public void returnNonHubDevice() {
        UsbDevice nonHub = mock(UsbDevice.class);

        when(adapter.getUsbPorts()).thenReturn(Collections.singletonList(usbPort));
        when(usbPort.getUsbDevice()).thenReturn(nonHub);

        assertThat(factory.create().size()).isEqualTo(1);
    }

    @Test
    public void returnAllDevicesOnNonHubs() {
        UsbDevice nonHub = mock(UsbDevice.class);
        UsbPort usbPort2 = mock(UsbPort.class);
        UsbDevice usbDevice2 = mock(UsbDevice.class);

        when(adapter.getUsbPorts()).thenReturn(asList(usbPort, usbPort2));

        when(usbPort.getUsbDevice()).thenReturn(nonHub);
        when(usbPort2.getUsbDevice()).thenReturn(usbDevice2);

        assertThat(factory.create().size()).isEqualTo(2);
    }

    @Test
    public void returnAllDevicesOnBothHubsAndNonHubs() {
        UsbPort nonHubPort = mock(UsbPort.class);
        UsbDevice nonHubDevice = mock(UsbDevice.class);

        when(adapter.getUsbPorts()).thenReturn(asList(usbPort, nonHubPort));

        when(usbPort.getUsbDevice()).thenReturn(usbHub);
        when(usbHub.isUsbHub()).thenReturn(true);
        when(usbHub.getAttachedUsbDevices()).thenReturn(asList(mock(UsbDevice.class), mock(UsbDevice.class)));

        when(nonHubPort.getUsbDevice()).thenReturn(nonHubDevice);

        assertThat(factory.create().size()).isEqualTo(3);
    }
}