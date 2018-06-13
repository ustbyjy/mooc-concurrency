package com.ascend.concurrency.example.singleton;

import com.ascend.concurrency.annotations.NotThreadSafe;

/**
 * 懒汉模式，双重检测，但非线程安全，有可能发生指令重排
 */
@NotThreadSafe
public class SingletonExample4 {

    private static SingletonExample4 instance = null;

    private SingletonExample4() {

    }

    /**
     * new SingletonExample4()有可能发生指令重排，抽象为下面几条JVM指令：
     * <p>memory =allocate(); //1：分配对象的内存空间</p>
     * <p>ctorInstance(memory); //2：初始化对象</p>
     * <p>instance =memory; //3：设置instance指向刚分配的内存地址</p>
     *
     * @return
     */
    public static SingletonExample4 getInstance() {
        if (instance == null) {
            synchronized (SingletonExample4.class) {
                if (instance == null) {
                    instance = new SingletonExample4();
                }
            }
        }
        return instance;
    }
}
