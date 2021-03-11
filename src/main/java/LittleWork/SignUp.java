package LittleWork;

import java.util.concurrent.Semaphore;

/**
 * 签到签退
 * @author 12640
 */
public class SignUp {
    Semaphore mutext = new Semaphore(1);
    Semaphore people = new Semaphore(20);
    public void SignUp() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    try {
                        people.acquire();
                        mutext.acquire();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("签到签到");
                    mutext.release();
                }
            }
        }).start();

    }
    public void SignOut(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    try {
                        mutext.acquire();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("签退签退");
                    people.release();
                    mutext.release();
                }
            }
        }).start();
    }

    public static void main(String[] args) {
        SignUp sign=new SignUp();
            sign.SignUp();
            sign.SignOut();
    }
}
