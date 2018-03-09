package com.skylarwatson.blinky.internal;

import com.skylarwatson.blinky.internal.factory.UsbHubFactory;

import javax.usb.UsbDevice;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class BlinkFinder {
    private UsbHubFactory factory = new UsbHubFactory();

    public List<UsbDevice> find() {
        List<UsbDevice> attachedUsbDevices = factory.create();
        return attachedUsbDevices.stream().filter(this::isCorrectProduct).collect(toList());
    }

    private boolean isCorrectProduct(UsbDevice device) {
        return device.getUsbDeviceDescriptor().idProduct() == 0x01ed;
    }
}