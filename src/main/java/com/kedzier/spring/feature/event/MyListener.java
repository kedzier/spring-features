package com.kedzier.spring.feature.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author kedzierm
 */
@Component
public class MyListener {

    private static final Logger LOG = LoggerFactory.getLogger(MyListener.class);

    @EventListener//(condition = "#event.id < 100")
    public void myListeningMethod(MyEvent event) {
        heavyOperation();
        LOG.info("Handling event [{}]", event);
    }

    @EventListener
    public void myTransactionalListeningMethod(MyAnotherEvent event) {
        heavyOperation();
        LOG.info("Handling another event [{}]", event);
    }

    private void heavyOperation() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            LOG.error("interrupted", e);
        }
    }

}
