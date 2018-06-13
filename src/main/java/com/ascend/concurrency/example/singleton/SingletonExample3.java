package com.ascend.concurrency.example.singleton;

import com.ascend.concurrency.annotations.NotRecommend;
import com.ascend.concurrency.annotations.ThreadSafe;

/**
 * 懒汉模式
 */
@ThreadSafe
@NotRecommend
public class SingletonExample3 {

    private static SingletonExample3 instance = null;

    private SingletonExample3() {

    }

    public synchronized static SingletonExample3 getInstance() {
        if (instance == null) {
            instance = new SingletonExample3();
        }
        return instance;
    }
}
