package ReaderQuestion;

/**
 * 椅子线程，当读者使用后释放椅子
 * @author 12640
 */
public class Chair extends Thread{
    Libary libary=new Libary();

    @Override
    public void run() {
        try {
            sleep(1000);
            System.out.println("学习，学个屁，走了走了");
            libary.chair.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
