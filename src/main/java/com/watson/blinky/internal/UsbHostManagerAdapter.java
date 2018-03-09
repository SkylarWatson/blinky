package com.watson.blinky.internal;

import javax.usb.UsbException;
import javax.usb.UsbHostManager;
import javax.usb.UsbPort;
import java.util.List;

public class UsbHostManagerAdapter {
    public List<UsbPort> getUsbPorts() {
        try {
            return UsbHostManager.getUsbServices().getRootUsbHub().getUsbPorts();
        } catch (UsbException ignore) {
            ignore.printStackTrace();
        }
        return null;
    }
}
