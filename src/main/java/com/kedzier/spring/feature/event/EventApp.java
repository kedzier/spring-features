package com.kedzier.spring.feature.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author kedzierm
 */
@SpringBootApplication
@EnableTransactionManagement
@ComponentScan(basePackages = "com.kedzier.spring.feature.event")
public class EventApp implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(EventApp.class, args);
    }

    @Transactional
    @Override
    public void run(String... strings) throws Exception {

        eventPublisher.publishEvent(new MyAnotherEvent(999L, "anotherEvent"));

        eventPublisher.publishEvent(new MyEvent(1L, "first"));
        eventPublisher.publishEvent(new MyEvent(2L, "second"));
        eventPublisher.publishEvent(new MyEvent(1000L, "third"));

        throw new RuntimeException("Rollback transaction");
    }

    @Autowired
    private ApplicationEventPublisher eventPublisher;

}

