package Smoker;

/**
 * 吸烟者进程
 * @author 12640
 */
public class Smoker extends Thread{
    private Table table;
    private String name;
    public Smoker(Table table,String name){
        this.table=table;
        this.name=name;
    }

    @Override
    public void run() {
        while (true) {
            if (table.isOffer1()) {
                smoke();//吸烟
                table.end();//吸烟结束 end方法中设标志位true
            }
        }
    }



    private void smoke(){
        System.out.println(name+"得到了烟草和纸，开吸");
    }
}
