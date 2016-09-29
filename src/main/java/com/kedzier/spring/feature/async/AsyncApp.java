package com.kedzier.spring.feature.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import java.util.concurrent.Executor;

/**
 * @author kedzierm
 */
@SpringBootApplication
@Configuration
@ComponentScan(basePackages = "com.kedzier.spring.feature.async")
@EnableAsync
@EnableScheduling
public class AsyncApp implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(AsyncApp.class, args);
    }

    @Bean
    @Qualifier("my")
    public Executor myTaskExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setMaxPoolSize(3);
        taskExecutor.setCorePoolSize(3);
        taskExecutor.setThreadNamePrefix("MY_EXECUTOR-thread-");
        return taskExecutor;
    }

    @Bean
    public TaskScheduler myTaskScheduler() {
        ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler ();
        taskScheduler.setPoolSize(3);
        taskScheduler.setThreadNamePrefix("MY_SCHEDULER-thread-");
        return taskScheduler;
    }

    @Override
    public void run(String... strings) throws Exception {

        // 2 scenarios
        //asyncDemo.simpleAsyncDemo();
        //asyncDemo.asyncWithReturnDemo();

    }

    @Autowired
    private AsyncDemo asyncDemo;

}

