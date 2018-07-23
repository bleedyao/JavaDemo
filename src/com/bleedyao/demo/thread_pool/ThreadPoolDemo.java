package com.bleedyao.demo.thread_pool;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.*;

/**
 * 结果发现 非核心线程会先执行队列里面的任务
 */
public class ThreadPoolDemo {
    private static int count = 0;

    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " task: " + count++);
                try {
                    Thread.sleep(30_000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
//
//        ExecutorService pool = new ThreadPoolExecutor(2, 50,
//                0, TimeUnit.SECONDS, new LinkedBlockingQueue<>(50));
//        new Timer().schedule(new TimerTask() {
//            @Override
//            public void run() {
//                pool.execute(r);
//            }
//        }, 0, 200);


        ScheduledExecutorService pool = Executors.newScheduledThreadPool(5);
        while (true){
            pool.schedule(r,0,TimeUnit.SECONDS);
        }
    }
}
