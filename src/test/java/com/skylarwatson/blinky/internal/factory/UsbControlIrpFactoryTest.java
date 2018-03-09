package com.skylarwatson.blinky.internal.factory;

import org.junit.Before;
import org.junit.Test;

import static javax.usb.UsbConst.*;
import static org.assertj.core.api.Assertions.assertThat;

public class UsbControlIrpFactoryTest {
    private UsbControlIrpFactory factory;

    @Before
    public void setup() {
        factory = new UsbControlIrpFactory();
    }

    @Test
    public void setBmRequestTypeOnUsbControl() {
        assertThat(factory.create().bmRequestType()).isEqualTo((byte) (REQUESTTYPE_TYPE_CLASS | REQUESTTYPE_RECIPIENT_INTERFACE));
    }

    @Test
    public void setBRequestOnUsbControl() {
        assertThat(factory.create().bRequest()).isEqualTo(REQUEST_SET_CONFIGURATION);
    }

    @Test
    public void setWValueOnUsbControl() {
        assertThat(factory.create().wValue()).isEqualTo((short) 3);
    }

    @Test
    public void setWIndexOnUsbControl() {
        assertThat(factory.create().wIndex()).isEqualTo((short) 0);
    }
}