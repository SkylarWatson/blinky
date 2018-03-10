package com.skylarwatson.blinky.internal.command;

import com.skylarwatson.blinky.internal.BlinkFinder;
import com.skylarwatson.blinky.internal.factory.UsbControlIrpFactory;

import javax.usb.UsbControlIrp;
import javax.usb.UsbException;

public class CommandSender {
    private UsbControlIrpFactory irpFactory = new UsbControlIrpFactory();
    private BlinkFinder finder = new BlinkFinder();

    public void send(BlinkCommand command) {
        try {
            UsbControlIrp usbControlIrp = irpFactory.create();
            usbControlIrp.setData(command.getData());

            finder.find().get(0).syncSubmit(usbControlIrp);
        } catch (UsbException ignore) {
            ignore.printStackTrace();
        }
    }
}
