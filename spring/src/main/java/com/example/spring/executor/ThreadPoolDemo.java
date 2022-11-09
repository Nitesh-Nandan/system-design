package com.example.spring.executor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ThreadPoolDemo {

    @Scheduled(cron = "* 53 16 * * *")
    public void run() {
        System.out.println("Run ho gaya");
    }

}
