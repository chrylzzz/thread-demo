package com.lnsoft.thread;

/**
 * Created By Chr on 2019/1/16/0016.
 */
public class TraditionalThread {

    public static void main(String args[]) {
        /**
         * 先运行 子类 方法里的run，如果没有就去找父类的run方法，父类再去找Runnable，
         * 现在有子类的run，以子类的为准
         */
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("Runnbale:" + Thread.currentThread().getName());
                }
            }
        }) {
            public void run() {
                while (true) {
                    System.out.println("Thread:" + Thread.currentThread().getName());
                }
            }
        }.start();
    }
}
