package com.skylarwatson.blinky.demo;

import com.skylarwatson.blinky.api.BlinkRule;
import com.skylarwatson.blinky.api.Blinker;
import com.skylarwatson.blinky.api.config.LED;
import com.skylarwatson.blinky.api.config.RGB;

@Blinker(color = RGB.ORANGE, led = LED.TOP)
public class BlinkDemo implements BlinkRule {
    @Override
    public boolean illuminate() {
        return true;
    }
}
