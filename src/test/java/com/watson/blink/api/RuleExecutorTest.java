package com.watson.blink.api;

import org.junit.Test;

import java.util.Collections;

public class RuleExecutorTest {
    @Test(expected = IllegalArgumentException.class)
    public void throwExceptionIfNotOfBlinkRuleType() {
        new RuleExecutor().execute(Collections.singletonList(String.class));
    }
}