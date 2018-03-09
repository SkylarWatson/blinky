package com.watson.blinky.demo;

import com.watson.blinky.api.BlinkRule;
import com.watson.blinky.api.Blinker;

@Blinker
public class BlinkDemo implements BlinkRule {
    @Override
    public boolean illuminate() {
        return true;
    }
}
