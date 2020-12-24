package DiskDistr;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author 12640
 */

public class DiskMain {
    /*
    public static void main(String[] args) {
        Random r = new Random();
        // 生成随机数
        Scanner in = new Scanner(System.in);
        System.out.println("请输入当前磁道的个数,随机生成磁道号：");
        int s = in.nextInt();
        // 磁道个数
        OS[] a = new OS[100];
        // new了100个引用
        // OS[] b = new OS[100];
        System.out.println("生成的随机磁道号为：");
        for (int i = 0; i < s; i++) {
            a[i] = new OS();
            // 分配内存空间
            a[i].Set_x(r.nextInt(200));
            System.out.println(a[i].Get_x() + "　");
        }
    }
    */

    /**
     *
     */
    public void FCFS(){
        /*
        System.out.print("请输入当前磁盘号：");
        Scanner in = new Scanner(System.in);
        now = in.nextInt();
        // 当前磁头位置
        System.out.println("磁盘调度顺序：");
        for (int i = 0; i < s; i++)
            System.out.print(a[i].Get_x() + " ");
        for (int i = 0; i < s; i++) {
            a[i].Set_y(now - a[i].Get_x());
            if (a[i].Get_y()< 0)
                a[i].Set_y(-a[i].Get_y());
            // 外围磁道与最里面磁道的距离
            sum += a[i].Get_y();
            now = a[i].Get_x();
        }*/
    }

    /**
     *
     */
    public void SSTF(){
        /*
        System.out.print("请输入当前磁盘号：");
        Scanner in = new Scanner(System.in);
        now = in.nextInt(); // 当前磁头位置
        System.out.println("磁盘调度顺序：");
        // 找出每一次与当前磁头位置距离最小的磁道
        for (int i = 0; i < s; i++) {
            a[i].Set_y(now - a[i].Get_x());
            // 记录每一个磁道与磁头的距离
            if (a[i].Get_y() < 0) {
                a[i].Set_y(-a[i].Get_y());
            }
        }
        for (int k = 0; k < s; k++) {
            // 将差值最小的放置最前面
            for (int i = 0; i < s - 1; i++) {
                for (int j = i + 1; j < s; j++)
                    if (a[i].Get_y() > a[j].Get_y()) {
                        temp = a[i];
                        a[i] = a[j];
                        a[j] = temp;
                    }
            }
            System.out.print(a[k].Get_x() + " ");
            sum += a[k].Get_x();
        }

         */
    }

    /**
     *
     */
    public void SCAN(){
        /*
        System.out.print("请输入当前磁盘号：");
        Scanner in = new Scanner(System.in);
        now = in.nextInt(); // 当前磁头位置
        System.out.println("磁盘调度顺序：");
        for (int i = 0; i < s; i++)// 对访问磁道按由小到大顺序排序
            for (int j = i + 1; j < s; j++)
                if (a[i].Get_x() > a[j].Get_x()) {
                    temp = a[i].Get_x();
                    a[i].Set_x(a[j].Get_x());
                    a[j].Set_x(temp);
                }
        // 输出排好序的磁盘
        System.out.println();
        int flag = 1;
        for (int i = 0; i < s; i++) {    //先从比磁头大的磁道开始，磁头向外移动
            if (a[i].Get_x() > now) {
                a[i].Set_y(a[i].Get_x() - now);
                now = a[i].Get_x();
                sum += a[i].Get_y();
                flag++;
                System.out.print(a[i].Get_x() + " ");
            }
        } // for
        if (flag <= 9)
            for (int i = s - flag; i >= 0; i--) {
                a[i].Set_y(now - a[i].Get_x());
                now = a[i].Get_x();
                sum += a[i].Get_y();
                System.out.print(a[i].Get_x() + " ");
            } // if

         */
    }

    /**
     *
     */
    public void CSCAN(){
        /*
        System.out.print("请输入当前磁盘号：");
        Scanner in = new Scanner(System.in);
        now = in.nextInt();
        // 当前磁头位置
        System.out.println("磁盘调度顺序：");
        for (int i = 0; i < s; i++)
            // 对访问磁道按由小到大顺序排列
            for (int j = i + 1; j < s; j++)
                if (a[i].Get_x() > a[j].Get_x()) {
                    temp = a[i].Get_x();
                    a[i].Set_x(a[j].Get_x());
                    a[j].Set_x(temp);
                }
        // 输出排序结果
        for (int i = 0; i < s; i++) {
            System.out.print(a[i].Get_x() + " ");
        }
        int flag = 0;
        for (int i = 0; i < s; i++) {
            if (a[i].Get_x() > now) {
                a[i].Set_y(a[i].Get_x() - now);
                now = a[i].Get_x();
                sum += a[i].Get_y();
                flag++;
            }
        } // for
        a[0].Set_y(now - a[s - 1].Get_x());
        for (int i = 1; i < s - flag; i++) {
            a[i].Set_y(now - a[i].Get_x());
            now = a[i].Get_x();
            sum += a[i].Get_y();
        }*/
    }


}

