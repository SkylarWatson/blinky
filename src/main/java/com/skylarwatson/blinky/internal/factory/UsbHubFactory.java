package com.skylarwatson.blinky.internal.factory;

import com.skylarwatson.blinky.internal.UsbHostManagerAdapter;

import javax.usb.UsbDevice;
import javax.usb.UsbHub;
import javax.usb.UsbPort;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class UsbHubFactory {
    private UsbHostManagerAdapter adapter = new UsbHostManagerAdapter();

    public List<UsbDevice> create() {
        List<UsbPort> ports = adapter.getUsbPorts();

        return Stream.concat(
                devicesNotFoundOnHub(ports),
                devicesFoundOnHub(ports)
        ).collect(toList());
    }

    private Stream<UsbDevice> devicesFoundOnHub(List<UsbPort> portStream) {
        return portStream.stream().filter(port -> port.getUsbDevice().isUsbHub())
                .map(port -> (UsbHub) port.getUsbDevice())
                .map(device -> (List<UsbDevice>) device.getAttachedUsbDevices())
                .flatMap(List::stream);
    }

    private Stream<UsbDevice> devicesNotFoundOnHub(List<UsbPort> portStream) {
        return portStream.stream()
                .filter(port -> !port.getUsbDevice().isUsbHub())
                .map(UsbPort::getUsbDevice);
    }
}
