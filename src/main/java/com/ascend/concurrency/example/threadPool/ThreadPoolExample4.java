package com.ascend.concurrency.example.threadPool;

import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
public class ThreadPoolExample4 {

    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(3);

//        executorService.schedule(new Runnable() {
//            @Override
//            public void run() {
//                log.info("schedule run");
//            }
//        }, 3, TimeUnit.SECONDS);

        executorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                log.info("scheduleAtFixedRate run");
            }
        }, 1, 3, TimeUnit.SECONDS);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                log.info("TimerTask run");
            }
        }, new Date(), 5 * 1000);

//        executorService.shutdown();
    }
}