package com.sohu.yifanshi.test.VolatileTest;

import javax.management.relation.RoleUnresolved;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class MyTest {
    public static volatile String[] table  = new String[]{"1","2"};
    public static ThreadLocal<Integer> th = new ThreadLocal<>();
    public static void main(String[] args) {
        MyTest.th.set(1);
        System.out.println(MyTest.th.get());
        /*new Thread(new Runnable() {
            @Override
            public void run() {
                    String localvalue = table[1];
                    while (true) {
                        if(!table[1].equals(localvalue))
                        {
                            System.out.println("reader found that value changed to --" +table[1]);
                            localvalue = table[1];
                        }

                    }

            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {

                    while (true)
                    {
                        System.out.println("updater changed the value to "+ (table[1]+="1"));
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

            }
        }).start();*/
    }
}
