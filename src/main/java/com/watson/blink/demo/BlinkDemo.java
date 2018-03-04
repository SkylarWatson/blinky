package com.watson.blink.demo;

import com.watson.blink.api.BlinkRule;
import com.watson.blink.api.Blinker;

@Blinker
public class BlinkDemo implements BlinkRule {
    @Override
    public boolean illuminate() {
        return true;
    }
}
