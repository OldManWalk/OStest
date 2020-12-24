package Music;

import Smoker.Table;

public class Musicer extends  Thread{
    private Table table;
    private String name;
    public Musicer(Table table,String name){
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
        System.out.println(name+"得到了音乐磁带和电池，开唱歌");
    }
}
