package com.bleedyao.demo.thread_local;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadLocalDemo {
    public static void main(String[] args) {
//        demo01();
        demo02();
    }

    private static void demo02() {
        AtomicInteger i = new AtomicInteger(10);
        ThreadLocal<Integer> mStringThreadLocal = new ThreadLocal<>();
        Runnable r = () -> {

            mStringThreadLocal.set(i.getAndIncrement());
            System.out.println(mStringThreadLocal.get());
        };

        ExecutorService pool = Executors.newFixedThreadPool(5);
        pool.execute(r);
        pool.execute(r);
        pool.execute(r);
        pool.execute(r);
        pool.execute(r);
        pool.shutdown();

    }

    private static void demo01() {
        ThreadLocal<String> mStringThreadLocal = new ThreadLocal<String>() {
            @Override
            protected String initialValue() {
                return Thread.currentThread().getName();
            }
        };
        Thread t = new Thread("#Thread-0") {

            @Override
            public void run() {
                super.run();
                mStringThreadLocal.set("bleedyao.com");
                System.out.println(Thread.currentThread().getName()+" "+mStringThreadLocal.get());
            }
        };
        Thread t1 = new Thread("#Thread-1") {

            @Override
            public void run() {
                super.run();
                mStringThreadLocal.set("bleedyao.xyz");
                System.out.println(Thread.currentThread().getName()+" "+mStringThreadLocal.get());
            }
        };
        t.start();
        t1.start();

        System.out.println(Thread.currentThread().getName()+" "+mStringThreadLocal.get());
    }
}
