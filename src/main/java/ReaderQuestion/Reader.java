package ReaderQuestion;

/**
 * 读者线程
 * 但有一个读者线程时需要占用一个椅子信号量
 * @author 1264096750
 */
public class Reader extends Thread{
    Libary libary=new Libary();
    Chair chair= new Chair();

    /**
     * 首先只有一个读者能登记
     */
    @Override
    public void run() {
        try {
                while (true) {
                    libary.mutex.acquire();
                    libary.chair.acquire();
                    System.out.println("我登记了，椅子少了一个");
                    libary.mutex.release();
                    chair.run();
                }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
