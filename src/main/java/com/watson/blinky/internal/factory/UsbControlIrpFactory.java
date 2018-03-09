package com.watson.blinky.internal.factory;

import javax.usb.UsbConst;
import javax.usb.UsbControlIrp;
import javax.usb.util.DefaultUsbControlIrp;

public class UsbControlIrpFactory {
    public UsbControlIrp create() {
        return new DefaultUsbControlIrp(
                (byte) (UsbConst.REQUESTTYPE_TYPE_CLASS |
                        UsbConst.REQUESTTYPE_RECIPIENT_INTERFACE),
                UsbConst.REQUEST_SET_CONFIGURATION,
                (short) 3,
                (short) 0);
    }
}
