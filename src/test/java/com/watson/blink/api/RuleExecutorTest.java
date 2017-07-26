package com.watson.blink.api;

import org.junit.Before;
import org.junit.Test;

import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;

public class RuleExecutorTest {
    private RuleExecutor executor;

    @Before
    public void setup() {
        executor = new RuleExecutor();
    }

    @Test
    public void returnEmptyListWhenNoClassesAreProvided() {
        assertThat(executor.execute(emptyList())).isEmpty();
    }
    
    @Test
    public void returnEmptyListWhenMethodReturnsFalse() {
        assertThat(executor.execute(singletonList(StubRuleFalse.class))).isEmpty();
    }

    @Test
    public void returnClassNameWhenMethodReturnsTrue() {
        assertThat(executor.execute(singletonList(StubRule.class)).get(0).getSimpleName()).isEqualTo("StubRule");
    }

    static class StubRule implements BlinkRule {
        @Override
        public boolean shouldRun() {
            return true;
        }
    }

    static class StubRuleFalse implements BlinkRule {
        @Override
        public boolean shouldRun() {
            return false;
        }
    }
}
