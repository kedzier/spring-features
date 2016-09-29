package com.kedzier.spring.feature.scheduling;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

/**
 * @author kedzierm
 */
@SpringBootApplication
@Configuration
@ComponentScan(basePackages = "com.kedzier.spring.feature.scheduling")
@EnableScheduling
public class ScheduledApp implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ScheduledApp.class, args);
    }

    @Bean
    public TaskScheduler myTaskScheduler() {
        ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler ();
        taskScheduler.setPoolSize(2);
        taskScheduler.setThreadNamePrefix("MY_SCHEDULER-thread-");
        return taskScheduler;
    }

    @Override
    public void run(String... strings) throws Exception {

    }

}

