package com.skylarwatson.blinky.api;

import com.skylarwatson.blinky.api.config.RGB;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;

import static java.util.Collections.singletonList;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class BlinkApplicationRunnerTest {
    @InjectMocks private BlinkApplicationRunner runner;
    @Mock private AnnotationLoader annotationLoader;
    @Mock private Illuminator illuminator;
    @Mock private RuleExecutor executor;

    @Test
    public void dontIlluminateIfNoClassIsReturned() {
        when(executor.execute(any())).thenReturn(new ArrayList<>());

        runner.run();

        verifyZeroInteractions(illuminator);
    }

    @Test
    public void illuminateIfAnyClassIsReturned() {
        BlinkerContext context = new BlinkerContext();

        when(executor.execute(any())).thenReturn(singletonList(context));

        runner.run();

        verify(illuminator).illuminate(context);
    }
}