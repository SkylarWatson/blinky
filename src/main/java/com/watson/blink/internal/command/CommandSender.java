package com.watson.blink.internal.command;

import com.watson.blink.internal.BlinkFinder;
import com.watson.blink.internal.factory.UsbControlIrpFactory;

import javax.usb.UsbControlIrp;
import javax.usb.UsbException;

public class CommandSender {
    private UsbControlIrpFactory irpFactory = new UsbControlIrpFactory();
    private CommandFactory commandFactory = new CommandFactory();
    private BlinkFinder finder = new BlinkFinder();

    public void foo() {
        try {
            UsbControlIrp usbControlIrp = irpFactory.create();
            usbControlIrp.setData(commandFactory.create().getData());

            finder.find().get(0).syncSubmit(usbControlIrp);
        } catch (UsbException ignore) {
            ignore.printStackTrace();
        }
    }
}
