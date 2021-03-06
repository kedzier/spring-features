package com.kedzier.spring.feature.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
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

    @Bean
    public TaskExecutor myTaskExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setMaxPoolSize(3);
        taskExecutor.setCorePoolSize(3);
        taskExecutor.setThreadNamePrefix("MY_EXECUTOR-thread-");
        return taskExecutor;
    }

    //s@Bean
    public ApplicationEventMulticaster applicationEventMulticaster() {
        SimpleApplicationEventMulticaster eventMulticaster = new SimpleApplicationEventMulticaster();
        eventMulticaster.setTaskExecutor(myTaskExecutor());
        return eventMulticaster;
    }

    @Transactional
    @Override
    public void run(String... strings) throws Exception {

        eventPublisher.publishEvent(new MyAnotherEvent(999L, "anotherEvent"));

        MyEvent myEvent = new MyEvent(1L, "first");
        eventPublisher.publishEvent(myEvent);
        eventPublisher.publishEvent(new MyEvent(2L, "second"));
        eventPublisher.publishEvent(new MyEvent(1000L, "third"));


        throw new RuntimeException("Rollback transaction");
    }

    @Autowired
    private ApplicationEventPublisher eventPublisher;

}

