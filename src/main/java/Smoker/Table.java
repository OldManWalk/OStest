package Smoker;

/**
 * 桌子类
 * 判断吸烟是否结束 end
 * 吸烟者1是否可以吸烟 offer1
 * 吸烟者2是否可以吸烟 offer2
 * 吸烟者3是否可以吸烟 offer3
 * @author 12640
 */
public class Table {
    private  boolean end=true;
    private  boolean offer1=false;
    private  boolean offer2=false;
    private  boolean offer3=false;
    public boolean isEnd() {
        return end;
    }

    public void setEnd(boolean end) {
        this.end = end;
    }

    public boolean isOffer1() {
        return offer1;
    }

    public void setOffer1(boolean offer1) {
        this.offer1 = offer1;
    }

    public boolean isOffer2() {
        return offer2;
    }

    public void setOffer2(boolean offer2) {
        this.offer2 = offer2;
    }

    public boolean isOffer3() {
        return offer3;
    }

    public void setOffer3(boolean offer3) {
        this.offer3 = offer3;
    }


    public synchronized void provide(){
        int random= (int) (Math.random()*3);
        if(random==0){
            System.out.println("1是否可以开始吸烟："+offer1);
            offer1=true;
            System.out.println("提供了烟草和纸");
        }else if(random==1){
            System.out.println("2是否可以开始吸烟："+offer1);
            offer2=true;
            System.out.println("提供了纸和胶水");
        }else {
            System.out.println("3是否可以开始吸烟："+offer1);
            offer3=true;
            System.out.println("提供了胶水和烟草");
        }
    }

    public synchronized void end(){
        if(offer1){
            offer1=false;
            //吸烟者不能连续多次吸烟
            System.out.println("吸烟者1吸烟结束");
            System.out.println("---------------------");
            setEnd(true);
            //吸烟结束 可以开始下一次随机分配资源
        }
        if(offer2){
            offer2=false;
            System.out.println("吸烟者2吸烟结束");
            System.out.println("---------------------");
            setEnd(true);
        }
        if(offer3){
            offer3=false;
            System.out.println("吸烟者3吸烟结束");
            System.out.println("---------------------");
            setEnd(true);
        }
    }
}
