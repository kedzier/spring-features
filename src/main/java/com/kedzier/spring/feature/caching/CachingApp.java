package com.kedzier.spring.feature.caching;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author kedzierm
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.kedzier.spring.feature.caching")
@EnableCaching
public class CachingApp implements CommandLineRunner {


    public static void main(String[] args) {
        SpringApplication.run(CachingApp.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {

        //demo.simpleEvictCachingDemo1();
        //demo.simpleEvictCachingDemo2();
        demo.smartCachingDemo();

    }

    @Bean
    CacheManager cacheManager() {
        return new ConcurrentMapCacheManager();
    }

    @Autowired
    private CachingDemo demo;
}

