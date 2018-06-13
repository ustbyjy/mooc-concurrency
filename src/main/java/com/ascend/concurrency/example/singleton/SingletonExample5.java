package com.ascend.concurrency.example.singleton;

import com.ascend.concurrency.annotations.Recommend;
import com.ascend.concurrency.annotations.ThreadSafe;

/**
 * 懒汉模式，双重检测，volatile禁止指令重排
 */
@ThreadSafe
@Recommend
public class SingletonExample5 {

    private volatile static SingletonExample5 instance = null;

    private SingletonExample5() {

    }

    public static SingletonExample5 getInstance() {
        if (instance == null) {
            synchronized (SingletonExample5.class) {
                if (instance == null) {
                    instance = new SingletonExample5();
                }
            }
        }
        return instance;
    }
}
