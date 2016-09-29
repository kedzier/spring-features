package com.kedzier.spring.feature.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * @author kedzierm
 */
@SpringBootApplication
@Configuration
@ComponentScan(basePackages = "com.kedzier.spring.feature.async")
@EnableAsync
public class AsyncApp implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(AsyncApp.class, args);
    }

    @Bean
    public TaskExecutor myTaskExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setMaxPoolSize(3);
        taskExecutor.setCorePoolSize(3);
        taskExecutor.setThreadNamePrefix("MY_EXECUTOR-thread-");
        return taskExecutor;
    }

    @Override
    public void run(String... strings) throws Exception {

        // 2 scenarios
        //asyncScenarios.simpleAsyncScenario();
        asyncScenarios.asyncWithReturnScenario();

    }

    @Autowired
    private AsyncScenarios asyncScenarios;


}

