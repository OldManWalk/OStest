import java.util.concurrent.Semaphore;

public class MyProcuder {
    private int in=0;
    private int out=0;
    int[] item=new int[10];
    Semaphore mutex=new Semaphore(1);
    Semaphore empty=new Semaphore(10);
    Semaphore full=new Semaphore(0);

    void producer()  {
        try
            {
                empty.acquire();
                mutex.acquire();
                item[in] = 10;
                in = (in + 1) % 10;
                mutex.release();
                empty.release();
            }
        catch(InterruptedException e)
            {
                System.out.println(e);
            }
    }

    void consumer()throws InterruptedException{
        full.acquire();
        mutex.acquire();

    }

}
