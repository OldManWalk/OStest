package Smoker;

/**
 *测试线程的运行
 * @author 12640
 */
public class Test {
    public static void main(String[] args) {
        Table table=new Table();
        Provider provider=new Provider(table);
        Smoker s1=new Smoker(table,"于谦");
        Smoker2 s2=new Smoker2(table,"郭德纲");
        Smoker3 s3=new Smoker3(table,"王源");

        provider.start();
        s1.start();
        s2.start();
        s3.start();
    }
}
