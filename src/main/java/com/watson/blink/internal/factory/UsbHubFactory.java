package com.watson.blink.internal.factory;

import javax.usb.UsbException;
import javax.usb.UsbHostManager;
import javax.usb.UsbHub;

public class UsbHubFactory {
    public UsbHub create() {
        try {
            return UsbHostManager.getUsbServices().getRootUsbHub();
        } catch (UsbException e) {
            e.printStackTrace();
        }

        return null;
    }
}
