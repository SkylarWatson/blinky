package com.watson.blink.api;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static java.util.stream.Collectors.toList;
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

    @Test
    public void returnAllClassNamesWhenMethodsReturnTrue() {
        List<String> result = executor.execute(
                asList(StubRule.class, StubRule2.class, StubRuleFalse.class)
        ).stream().map(Class::getSimpleName).collect(toList());

        assertThat(result).containsOnly("StubRule", "StubRule2");
    }

    static class StubRule implements BlinkRule {
        @Override
        public boolean shouldRun() {
            return true;
        }
    }

    static class StubRule2 implements BlinkRule {
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
