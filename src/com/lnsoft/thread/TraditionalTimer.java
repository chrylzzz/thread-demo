package com.lnsoft.thread;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created By Chr on 2019/1/16/0016.
 */
public class TraditionalTimer {
    private static int count = 0;

    public static void main(String args[]) {
        //=======定时器,10s开始，3秒一循环====================

      /*  new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("bombing~~~");
            }
        }, 10000, 3000);*/

        //=======2s一循环======================
       /* class MyTaskTimer extends TimerTask {
            @Override
            public void run() {
                System.out.println("bombing~~~");

                new Timer().schedule(
                        new MyTaskTimer(), 2000);
            }
        }
        ;*/
        //=======2s一循环======================
      class MyTaskTimer2 extends TimerTask {
            @Override
            public void run() {
                count = (count + 1) % 2;

                System.out.println("bombing~~~");

                new Timer().schedule(
                        new MyTaskTimer2(), 2000+2000*count);
            }
        }
        ;
      new Timer().schedule(new MyTaskTimer2(),2000);

      while (true){
          System.out.println(new Date().getSeconds());
          try {
              Thread.sleep(1000);
          }catch (Exception e){
              e.printStackTrace();
          }
      }

    }
}
