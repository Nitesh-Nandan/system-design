package com.example.spring.executor;

public class Job {
    public static void process(int val) {
        try {
            Thread.sleep(5000);
            System.out.println(Thread.currentThread().getName() + " Printing " + val);
        } catch (Exception ex) {
            System.out.println(Thread.currentThread().getName() + " Interrupted");
        }
    }
}
