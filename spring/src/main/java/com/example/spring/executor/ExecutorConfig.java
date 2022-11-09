package com.example.spring.executor;

import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Component
public class ExecutorConfig {

    @Bean("test-thread")
    public ThreadPoolTaskExecutor commonThreadPoolExecutor() {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();

        threadPoolTaskExecutor.setCorePoolSize(1);
        threadPoolTaskExecutor.setMaxPoolSize(2);
        threadPoolTaskExecutor.setQueueCapacity(100);
        threadPoolTaskExecutor.setThreadNamePrefix("TestThread - ");

        return threadPoolTaskExecutor;
    }

    @Bean("test-nn")
    public ThreadPoolExecutor getThreadPoolExecutor() {
        BlockingQueue<Runnable> blockingQueue =
                new LinkedBlockingQueue<Runnable>();

        ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 3, 5, TimeUnit.SECONDS, blockingQueue);

        return executor;
    }
}
