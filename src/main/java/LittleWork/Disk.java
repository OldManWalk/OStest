package LittleWork;

import java.util.concurrent.Semaphore;

public class Disk {
    Semaphore empty = new Semaphore(20);
    Semaphore full = new Semaphore(0);
    Semaphore mutext = new Semaphore(1);
    public void Input(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    try {
                        System.out.println("读磁盘记录");
                        empty.acquire();
                        mutext.acquire();
                        System.out.println("存入缓冲区");
                        full.release();
                        mutext.release();
                    } catch (Exception e) {

                    }
                }
            }
        }).start();
    }
    public void Output(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        full.acquire();
                        mutext.acquire();
                        System.out.println("取出磁盘记录");
                        System.out.println("进行计算");
                        empty.release();
                        mutext.release();
                    } catch (Exception e) {

                    }
                }
            }
        }).start();
    }

    public static void main(String[] args) {
        Disk disk =new Disk();
        disk.Input();
        disk.Output();
    }
}
