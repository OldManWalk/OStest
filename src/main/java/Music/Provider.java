package Music;

import Smoker.Table;

/**
 *
 * @author 12640
 */
public class Provider extends Thread{
    private Table table;
    public Provider(Table table){
        this.table=table;
    }
    int count=0;
    @Override
    public void run() {
        while (true){
            while (table.isEnd()) {
                table.provide();
                table.setEnd(false);
                //提供资源后开始唱歌将开始，设为false
            }
        }
    }
}
