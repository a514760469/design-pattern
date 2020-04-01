package com.gds.async.invocation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.mockito.internal.verification.VerificationModeFactory;

import java.time.Duration;
import java.util.Optional;
import java.util.concurrent.Callable;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author zhanglifeng
 * @since 2020-03-30 18:24
 */
public class AppTest {

    @Captor
    private ArgumentCaptor<Optional<Exception>> optionalCaptor;

    @Mock
    private Callable<Object> task;

    @Mock
    private AsyncCallback<Object> callback;

    @BeforeEach
    void setUp() {
        // mock的初始化和注入  或者@RunWith(MockitoJUnitRunner.class)
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testSuccessfulTaskWithoutCallback() {
        assertTimeout(Duration.ofMillis(3000), () -> {
            ThreadAsyncExecutor executor = new ThreadAsyncExecutor();
            Object result = new Object();
            Mockito.when(task.call()).thenReturn(result);
            AsyncResult asyncResult = executor.startProcess(task);
            assertNotNull(asyncResult);
            asyncResult.await();
            assertTrue(asyncResult.isCompleted());

            Mockito.verify(task, VerificationModeFactory.times(1)).call();
            assertSame(result, asyncResult.getValue());
        });

    }
}