package Smoker;

/**
 * 吸烟者进程
 * @author 12640
 */
public class Smoker2 extends Thread{
    private Table table;
    private String name;
    public Smoker2(Table table, String name){
        this.table=table;
        this.name=name;
    }

    @Override
    public void run() {
        while (true) {
            if (table.isOffer2()) {
                smoke();//吸烟
                table.end();//吸烟结束 end方法中设标志位true
            }
        }
    }



    private void smoke(){
        System.out.println(name+"得到了打火机和纸，开吸");
    }
}
