package ReaderQuestion;

import java.util.concurrent.Semaphore;

public class Libary {
    public Semaphore chair =new Semaphore(100);
   public Semaphore mutex=new Semaphore(1);
    public static void main(String[] args) {
         Reader reader=new Reader();
             reader.run();
    }
}
