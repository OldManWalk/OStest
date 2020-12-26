package Bar;

import java.util.concurrent.Semaphore;

public class Barber {
    /**
     *  顾客等待的数量
     *  互斥访问 wait
     *  顾客的信号量
     */
    int wait = 0;
    Semaphore mutex=new Semaphore(1);
    Semaphore barber=new Semaphore(1);
    Semaphore customer=new Semaphore(1);

    public static void main(String[] args) throws InterruptedException {
        Barber b=new Barber();
        b.barber();
        b.customer();
    }
    /**
    理发师
     **/
    void barber(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        mutex.acquire();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if(wait>0){
                        try {
                            customer.acquire();

                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        wait=wait-1;
                        System.out.println("剪了一个人的头");
                        barber.release();
                        mutex.release();
                    }else {
                        System.out.println("睡觉");
                        mutex.release();

                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();
    }

    /**
     * 顾客
     */
    void customer () throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        mutex.acquire();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //申请互斥访问wait
                    if (wait < 10) {
                        //代表10把椅子没有坐满 还可以坐人
                        wait = wait + 1 ;
                        System.out.println("顾客在等待");
                        mutex.release();
                        customer.release();
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        //等待理发师来理发
                    } else {
                        //人满了 顾客直接离开

                        System.out.println("顾客离开了");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        mutex.release();
                    }
                }
            }
        }).start();

    }
}
