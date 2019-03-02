package com.lnsoft.thread;

/**
 * Created By Chr on 2019/1/16/0016.
 */
public class TraditionalSynchronized {

    public static void main(String args[]) {
        new TraditionalSynchronized().init();
    }

    public void init() {
        Outputer outputer = new Outputer();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    outputer.outPut("xiaoMing");
                }
            }
        }) {
        }.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    outputer.outPut("xiaoHong");
                }
            }
        }) {
        }.start();
    }

    static class Outputer {
        public void outPut(String name) {
            synchronized (Outputer.class) {//Outputer.class字节码
                for (int x = 0; x < name.length(); x++) {
                    System.out.print(name.charAt(x));
                }
                System.out.println();
            }
        }

        public void outPut2(String name) {
            synchronized (this) {
                for (int x = 0; x < name.length(); x++) {
                    System.out.print(name.charAt(x));
                }
                System.out.println();
            }
        }

        public synchronized void outPut3(String name) {
            for (int x = 0; x < name.length(); x++) {
                System.out.print(name.charAt(x));
            }
            System.out.println();
        }

        /**
         * 类的字节码在内存中也算对象，静态的不用创建对象实例化是因为类的字节码在内存中就有了对象，静态的就用此对象
         * （静态的不使用类的实例化对象。是因为字节码在内存中也算对象）
         * 4和2一起用会互斥，静态引用字节码，this引用的是对象
         * @param name
         */
        public static synchronized void outPut4(String name) {//字节码
            for (int x = 0; x < name.length(); x++) {
                System.out.print(name.charAt(x));
            }
            System.out.println();
        }

    }
}
