package com.ascend.concurrency.example.threadStatus;

import lombok.extern.slf4j.Slf4j;

/**
 * 守护线程在退出的时候并不会执行finally块中的代码，所以将释放资源等操作不要放在finally块中执行，这种操作是不安全的
 */
@Slf4j
public class DaemonExample {

    public static void main(String[] args) {
        Thread daemonThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        log.info("i am alive");
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        log.info("finally block");
                    }
                }
            }
        });
        daemonThread.setDaemon(true);
        daemonThread.start();

        // 确保main线程结束前能给daemonThread能够分到时间片
        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            log.info("exception", e);
        }
    }

}
