package com.watson.blink.internal;

import com.watson.blink.internal.factory.UsbHubFactory;

import javax.usb.UsbDevice;
import java.util.List;
import java.util.stream.Collectors;

public class BlinkFinder {
    private UsbHubFactory factory = new UsbHubFactory();

    public List<UsbDevice> find() {
        List<UsbDevice> attachedUsbDevices = factory.create().getAttachedUsbDevices();

        return attachedUsbDevices.stream().filter(this::isCorrectVendorProduct).collect(Collectors.toList());
    }

    private boolean isCorrectVendorProduct(UsbDevice device) {
        return device.getUsbDeviceDescriptor().idProduct() == 0x01ed &&
               device.getUsbDeviceDescriptor().idVendor() == 0x27b8;
    }
}