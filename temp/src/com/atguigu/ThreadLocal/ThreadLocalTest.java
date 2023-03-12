package com.atguigu.ThreadLocal;

import java.util.Random;

/**
 * @author AOA
 * @version 1.0
 * @description: TODO
 * @date 2022/5/2 13:52
 */

public class ThreadLocalTest {
    private static ThreadLocal local = new ThreadLocal();
    private static Random random = new Random();


    public static class thread01 implements Runnable{
        public void run() {
            Integer i = random.nextInt(100);
            String name = Thread.currentThread().getName();
            System.out.println("这个线程名是 " + name + ",数据为 " + i);
            local.set(i);

            System.out.println("这个线程名是 " + name + ",数据为 " + i);
        }
    }


    public static void main(String[] args) {

        new Thread(new thread01()).start();


    }

}
