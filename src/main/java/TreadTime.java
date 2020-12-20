public class TreadTime {
    static int  total=0;

    static void P0()
    {
        int i=1;
        for(i=1;i<=10;i++) {
            total = total + 1;
        }
        System.out.println(total);
    }
    static void P1()
    {
        int i;
        for(i=1;i<=10;i++) {
            total = total + 1;
        }
        System.out.println(total);
    }

    public static void main(String[] args) {
            P1();
            P0();
    }
}
