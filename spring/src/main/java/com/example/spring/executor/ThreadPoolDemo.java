package com.example.spring.executor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.function.Supplier;

@Component
@Slf4j
public class ThreadPoolDemo {

    private final Executor executor;

    public ThreadPoolDemo(@Qualifier("test-nn") Executor executor) {
        this.executor = executor;
    }

    @Scheduled(cron = "* 49 17 * * *")
    public void run() throws InterruptedException {
        System.out.println("Run ho gaya");

        for (int i = 0; i < 50; i++) {
            final int arg = i;
            Supplier<Boolean> task = () -> {
                Job.process(arg);
                return Boolean.TRUE;
            };
            // you can call runAsync as well - ye bs play kar raha tha
            CompletableFuture.supplyAsync(task, executor);
            System.out.println("Pushed the data");
        }
    }

}
