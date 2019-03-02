package com.lnsoft.thread;

/**
 * Created By Chr on 2019/1/18/0018.
 *
 * 一般放在一个类中进行操作，写在资源类Busin：写在线程锁访问的那个资源类Busin中
 */
public class TraditionalThreadCommunication {

    public static void main(String args[]) {

        final Busin busin = new Busin();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 50; i++) {
                    busin.show(i);
                }
            }
        }).start();
        for (int i = 1; i <= 50; i++) {
            busin.show2(i);
        }
    }

    //线程的资源类
    static class Busin {

        boolean flag = true;

        public synchronized void show(int i) {
            while (!flag) {//if
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int x = 1; x <= 10; x++) {
                System.out.println("支线任务~~~~~~~~~~~~" + x);
            }
            flag = false;
            this.notify();
        }

        public synchronized void show2(int i) {
            while (flag) {//if
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int x = 1; x <= 100; x++) {
                System.out.println("主线任务==" + x);
            }
            flag = true;
            this.notify();
        }
    }
}
