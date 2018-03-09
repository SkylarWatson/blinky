package com.watson.blinky.internal.command;

import com.watson.blinky.internal.BlinkFinder;
import com.watson.blinky.internal.factory.UsbControlIrpFactory;

import javax.usb.UsbControlIrp;
import javax.usb.UsbException;

public class CommandSender {
    private UsbControlIrpFactory irpFactory = new UsbControlIrpFactory();
    private CommandFactory commandFactory = new CommandFactory();
    private BlinkFinder finder = new BlinkFinder();

    public void send() {
        try {
            UsbControlIrp usbControlIrp = irpFactory.create();
            usbControlIrp.setData(commandFactory.create().getData());

            finder.find().get(0).syncSubmit(usbControlIrp);
        } catch (UsbException ignore) {
            ignore.printStackTrace();
        }
    }
}
