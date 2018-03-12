package com.skylarwatson.blinky.api;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.emptyList;
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
        assertThat(executor.execute(createContextWith(StubRuleFalse.class))).isEmpty();
    }

    @Test
    public void returnClassNameWhenMethodReturnsTrue() {
        assertThat(executor.execute(createContextWith(StubRule.class)).get(0).getKlass().getSimpleName()).isEqualTo("StubRule");
    }

    @Test
    public void returnAllClassNamesWhenMethodsReturnTrue() {
        List<String> result = executor.execute(
                createContextWith(StubRule.class, StubRule2.class, StubRuleFalse.class)
        ).stream().map(it -> it.getKlass().getSimpleName()).collect(toList());

        assertThat(result).containsOnly("StubRule", "StubRule2");
    }

    static class StubRule implements BlinkRule {
        @Override
        public boolean illuminate() {
            return true;
        }
    }

    static class StubRule2 implements BlinkRule {
        @Override
        public boolean illuminate() {
            return true;
        }
    }

    static class StubRuleFalse implements BlinkRule {
        @Override
        public boolean illuminate() {
            return false;
        }
    }

    private List<BlinkerContext> createContextWith(Class<?>... rules) {
        List<BlinkerContext> result = new ArrayList<>();

        for (Class klass : rules) {
            BlinkerContext context = new BlinkerContext();
            context.setKlass(klass);
            result.add(context);
        }

        return result;
    }
}
