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

    /**
    理发师
     **/
    void P(Semaphore a){

    }
    void V(Semaphore a){

    }
    void barber() {
        while (true) {
            P(customer);
            //等待顾客来理发
            P(mutex);
            //申请互斥访问wait
            wait = wait - 1;
            // 等待人数减少一人
            V(mutex);
            //释放临界资源
            V(barber);
            //让理发师去理发
            System.out.print("我开始理发了");
        }
    }

    /**
     * 顾客
     */
    void customer () {
        while (true) {
            P(mutex);
            //申请互斥访问wait
            if (wait < 10) {
                //代表10把椅子没有坐满 还可以坐人
                wait = wait + 1 ;
                V(mutex);
                V(customer );
                P(barber);
                //等待理发师来理发
            } else {
                //人满了 顾客直接离开
                V(mutex);
            }
        }
    }
}
