package com.kedzier.spring.feature.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author kedzierm
 */
@Component
public class ScheduleExample {

    private static final Logger LOG = LoggerFactory.getLogger(ScheduleExample.class);

    //@Scheduled(fixedRate = 2000L)
    //@Scheduled(fixedDelay = 2000L)
    //@Scheduled(cron = "30 0/1 * 1/1 * ?") // each minute, at 00:30
    @Scheduled()
    public void scheduleAtDate() {
        LOG.info("Running scheduled");
        heavyOperation(1);
    }

    private void heavyOperation(int count) {
        try {
            Thread.sleep(count * 1_000L);
        } catch (InterruptedException e) {
            LOG.error("Interrupted", e);
        }
    }

}
