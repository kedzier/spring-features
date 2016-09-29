package com.kedzier.spring.feature.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

/**
 * @author kedzierm
 */
@Component
public class AsyncExample {

    private static final Logger LOG = LoggerFactory.getLogger(AsyncExample.class);

    @Async
    public void asyncMethod() {
        heavyOperation(1);
        LOG.info("I was executed in async way");
    }

    @Async
    public Future<String> asyncMethodWithReturn() {
        heavyOperation(3);
        LOG.info("I was executed in async way and I'm returning value");
        return new AsyncResult<>("hello async!");
    }

    private void heavyOperation(int count) {
        try {
            Thread.sleep(count * 1_000L);
        } catch (InterruptedException e) {
            LOG.error("Interrupted", e);
        }
    }

}
