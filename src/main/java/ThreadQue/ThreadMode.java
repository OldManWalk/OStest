package ThreadQue;

import java.util.Scanner;

/**
 * @author oldmanwalk
 */
public class ThreadMode {
    Scanner s = new Scanner(System.in);
    public void begin1(int n) {
        Scanner sr[] = new Scanner[n];
        PCBmode shuru[] = new PCBmode[n];
        int yxj[] = new int[n];
        int zzxtime = 0;
        // 总执行时间
        for (int i = 0; i < n; i++) {
            System.out.println("进程" + (i + 1) + "信息输入：");
            shuru[i] = new PCBmode();
            sr[i] = new Scanner(System.in);
            System.out.print("请输入进程名：");
            shuru[i].name = sr[i].nextLine();
            System.out.print("请输入优先级：");
            shuru[i].Super = sr[i].nextInt();
            yxj[i] = shuru[i].Super;
            // 每次将优先级传给数组
            System.out.print("请输入执行时间:");
            shuru[i].zxTime = sr[i].nextInt();
            System.out.print("请输入到达时间：");
            shuru[i].ddTime=sr[i].nextInt();
            zzxtime += shuru[i].zxTime;
            shuru[i].runTime = shuru[i].zxTime;
        }
        System.out.println("***************************************");
        for (int i = 0; i < zzxtime; i++) {
            System.out.println("*******************************这是第"+(i+1)+"次执行*****"
                    + "***************************************");
            sort(shuru);
            // 将优先级进行排序
            shuru[n - 1].Super -= 1;
            // 优先级减一
            shuru[n - 1].runTime = shuru[n - 1].runTime - 1;
            // 剩余执行次数减一
            System.out.println("现在正在执行的进程是：" + shuru[n - 1].name);
            System.out.println("进程名\t 优先级 \t 剩余执行时间 \t状态");
            shuru[n-1].statue="r";
            show(shuru[n - 1]);
            System.out.println("就绪中的进程有：");
            System.out.println("进程名\t 优先级 \t 剩余执行时间\t状态");
            for (int j = 0; j < n - 1; j++) {
                if (shuru[j].runTime != 0 && shuru[j].Super != 0) {
                    for (int k = j; k < n - 1; k++) {
                        shuru[k].statue="w";
                        show(shuru[k]);
                        break;
                    }
                }
            }
            if (shuru[n - 1].runTime == 0) {
                // 如果剩余执行次数为0，进程结束
                System.out.println("__________进程" + shuru[n - 1].name + "结束_____________");
                shuru[n - 1].Super = 0;
                // 如果一个进程执行完毕，将它的优先级置零
            }
        }
    }
    public void sort(PCBmode[] shuru) {
        // 比较优先级
        for (int i = 1; i <= shuru.length; i++) {
            // 计数，第几轮比较
            for (int j = 0; j < shuru.length - i; j++) {
                // 注意这一步，第一趟比较length次，第二趟比较length-1次,以此类推
                if (shuru[j].Super > shuru[j + 1].Super) {
                    PCBmode t = shuru[j];
                    shuru[j] = shuru[j + 1];
                    shuru[j + 1] = t;
                    // 交换
                }
            }
        }
    }

    public void sort1(PCBmode shuru[]) {//比较到达时间
        for (int i = 1; i <= shuru.length; i++) {// 计数，第几轮比较
            for (int j = 0; j<shuru.length - i; j++) {// 注意这一步，第一趟比较length次，第二趟比较length-1次,以此类推
                if (shuru[j].ddTime >shuru[j + 1].ddTime) {
                    PCBmode t = shuru[j];
                    shuru[j] = shuru[j + 1];
                    shuru[j + 1] = t;// 交换
                }
            }
        }
    }
    public void begin2(int n) {
        Scanner sr[] = new Scanner[n];
        PCBmode shuru[] = new PCBmode[n];
        int yxj[] = new int[n];
        int zzxtime = 0;// 总执行时间
        for (int i = 0; i < n; i++) {
            System.out.println("进程" + (i + 1) + "信息输入：");
            shuru[i] = new PCBmode();
            sr[i] = new Scanner(System.in);
            System.out.print("请输入进程名：");
            shuru[i].name = sr[i].nextLine();
            System.out.print("请输入执行时间:");
            shuru[i].zxTime = sr[i].nextInt();
            System.out.print("请输入到达时间：");
            shuru[i].ddTime=sr[i].nextInt();
            zzxtime += shuru[i].zxTime;
            shuru[i].runTime = shuru[i].zxTime;
        }
        int count=0;
        for(int i=0;i<zzxtime;i++) {
            System.out.println("*******************************"
                    + "**这是第"+(i+1)+"次执行**************************************");
            shuru[count].runTime = shuru[count].runTime - 1;// 剩余执行次数减一
            sort1(shuru);
            System.out.println("现在正在执行的进程是：" + shuru[count].name);
            System.out.println("进程名\t 剩余执行时间\t 到达时间\t\t状态");
            shuru[count].statue="r";
            show1(shuru[count]);
            System.out.println("就绪中的进程有：");
            System.out.println("进程名\t 剩余执行时间 \t到达时间\t\t状态");
            for(int j=count+1;j<n;j++) {
                shuru[j].statue="w";
                show1(shuru[j]);
            }
            if (shuru[count].runTime == 0) {// 如果剩余执行次数为0，进程结束
                System.out.println("__________进程" + shuru[count].name + "结束_____________");
                count++;
            }
        }
    }
    public void show(PCBmode shuru) {
        System.out.println(shuru.name + "\t" + shuru.Super + "\t " + shuru.runTime+"\t\t"+shuru.statue);
    }
    public void show1(PCBmode shuru) {
        System.out.println(shuru.name + "\t"  + shuru.runTime+"\t\t"+shuru.ddTime+"\t\t"+shuru.statue);
    }

    public static void main(String[] args) {
        ThreadMode j = new ThreadMode();
        Scanner s1 = new Scanner(System.in);
        System.out.print("请输入进程数目：");
        int n = s1.nextInt();
        System.out.println("请输入你要选择的调度算法：（1  最高优先数优先；2  先来先服务）");
        int choice=s1.nextInt();
        if(choice==1) {
            j.begin1(n);
        }else if(choice==2) {
            j.begin2(n);
        }
        else {
            System.out.println("输入错误！请重新输入！");
        }
        System.out.println("所有进程执行完毕！");
    }

}
