package LittleWork;

import java.util.concurrent.Semaphore;

/**
 * 车站只能进20人
 */
public class Station {
    Semaphore people =new Semaphore(20);

    /**
     * 进站
     */
   void customIn() {
       new Thread() {
           @Override
           public void run() {
               while (true) {
                   try {
                       people.acquire();
                       System.out.println("俺进入车站了");
                   } catch (InterruptedException e) {
                       System.out.println("咋不让俺进去啊");
                       e.printStackTrace();
                   }
               }
           }
       }.start();
    }

    /**
     * 出站
     */
    void customOut() {
        new Thread() {
            @Override
            public void run() {
                while (true) {
                        System.out.println("俺买完票了");
                        people.release();
                    try {
                        sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                }
            }.start();
    }
    public static void main(String[] args) {
       Station station=new Station();
        station.customOut();
        station.customIn();
    }
}
