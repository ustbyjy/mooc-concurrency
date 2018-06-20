package com.ascend.concurrency.example.syncContainer;

import lombok.extern.slf4j.Slf4j;

import java.util.Iterator;
import java.util.Vector;

@Slf4j
public class VectorExample3 {

    private static void test1(Vector<Integer> v) { //foreach, notThreadSafe
        for (Integer i : v) {
            if (i.equals(3)) {
                v.remove(i);
            }
        }
    }

    private static void test2(Vector<Integer> v) { //iterator, notThreadSafe
        Iterator<Integer> iterator = v.iterator();
        while (iterator.hasNext()) {
            Integer i = iterator.next();
            if (i.equals(3)) {
                v.remove(i);
            }
        }
    }

    private static void test3(Vector<Integer> v) { //for, threadSafe
        for (int i = 0; i < v.size(); i++) {
            if (v.get(i).equals(3)) {
                v.remove(i);
            }
            System.out.println(v.size());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Vector<Integer> vector = new Vector<>();
        vector.add(1);
        vector.add(2);
        vector.add(3);

//        test1(vector);
//        test2(vector);
        test3(vector);
    }

}
