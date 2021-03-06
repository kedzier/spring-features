package com.kedzier.spring.feature.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author kedzierm
 */
@Component
public class AsyncDemo  {

    public void simpleAsyncDemo() {
        for (int i = 0 ; i < 100 ; i++) {
            asyncExample.asyncMethod();
        }
    }

    public void asyncWithReturnDemo() throws ExecutionException, InterruptedException {
        Future<String> futureResult = asyncExample.asyncMethodWithReturn();
        LOG.info("Checking if task is done...");
        if (futureResult.isDone()) {
            LOG.info("... it is, with result [{}]", futureResult.get());
            return;
        } else {
            LOG.info("... it is not");
        }
        LOG.info("Waiting for task completion");
        LOG.info("Result is [{}]", futureResult.get());

    }

    private static final Logger LOG = LoggerFactory.getLogger(AsyncDemo.class);

    @Autowired
    private AsyncExample asyncExample;

}
