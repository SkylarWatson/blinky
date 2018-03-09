package com.skylarwatson.blinky.demo;

import com.skylarwatson.blinky.api.BlinkRule;
import com.skylarwatson.blinky.api.Blinker;

@Blinker
public class BlinkDemo implements BlinkRule {
    @Override
    public boolean illuminate() {
        return true;
    }
}
