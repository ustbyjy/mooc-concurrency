package com.ascend.concurrency.example.threadStatus;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JoinExample {

    public static void main(String[] args) {
        Thread previousThread = Thread.currentThread();
        for (int i = 1; i <= 10; i++) {
            Thread curThread = new JoinThread(previousThread);
            curThread.start();
            previousThread = curThread;
        }
    }

    static class JoinThread extends Thread {
        private Thread thread;

        public JoinThread(Thread thread) {
            this.thread = thread;
        }

        @Override
        public void run() {
            try {
                thread.join();
                log.info(thread.getName() + " terminated.");
            } catch (InterruptedException e) {
                log.error("exception", e);
            }
        }
    }
}
