package com.watson.blink.internal.factory;

import com.watson.blink.internal.UsbHostManagerAdapter;

import javax.usb.UsbDevice;
import javax.usb.UsbHub;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class UsbHubFactory {
    private UsbHostManagerAdapter adapter = new UsbHostManagerAdapter();

    public List<UsbDevice> create() {
        return adapter.getUsbPorts().stream()
                .map(port -> (UsbHub) port.getUsbDevice())
                .map(device -> (List<UsbDevice>) device.getAttachedUsbDevices())
                .flatMap(List::stream)
                .collect(toList());
    }
}
