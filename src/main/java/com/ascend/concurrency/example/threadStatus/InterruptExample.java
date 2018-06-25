package com.ascend.concurrency.example.threadStatus;

import lombok.extern.slf4j.Slf4j;

/**
 * 当抛出InterruptedException时候，会清除中断标志位；调用Thread.interrupted()也会清除中断标志位。
 */
@Slf4j
public class InterruptExample {

    public static void main(String[] args) {

        final Thread sleepThread = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    log.error("exception", e);
                }
                super.run();
            }
        };

        final Thread busyThread = new Thread() {
            @Override
            public void run() {
                while (true) ;
            }
        };

        sleepThread.start();
        busyThread.start();

        sleepThread.interrupt();
        busyThread.interrupt();

        while (sleepThread.isInterrupted()) ;

        log.info("sleepThread isInterrupted: " + sleepThread.isInterrupted());
        log.info("busyThread isInterrupted: " + busyThread.isInterrupted());

    }

}
