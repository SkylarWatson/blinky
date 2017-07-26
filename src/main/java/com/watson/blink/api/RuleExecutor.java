package com.watson.blink.api;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;

public class RuleExecutor {
    public <T extends BlinkRule> List<Class<? extends BlinkRule>> execute(List<Class<? extends BlinkRule>> classes) {
        try {
            if (!classes.isEmpty()) {
                Method method = classes.get(0).getMethod("shouldRun");
                Boolean result = (Boolean) method.invoke(classes.get(0).newInstance());

                if (result) return Collections.singletonList(classes.get(0));
            }
        } catch (Exception ignore) {
            ignore.printStackTrace();
        }
        return Collections.emptyList();
    }
}