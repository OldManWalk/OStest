package Bank;

import java.util.Scanner;

/**
 *Available用来存系统初始状态未分配时的可用资源量
 * Max用来存取进程最大需求矩阵
 * Alloction用来存取进程已经分配资源的矩阵
 * Need用来存取各进程还需要的资源的矩阵
 * Request用来存取用户输入的要检测的进程号和各类资源
 * Work用来检测系统安全性的
 * @author 12640
 */
public class Bank {
    private int[] Available;
    private int[][] Max;
    private int[][] Alloction;
    private int[][] Need;
    private int[][] Request;
    private int[] Work;
    private int resource;
    private int thread;

    int num = 0;
    Scanner input = new Scanner(System.in);

    public Bank(int resource,int thread){
        this.resource = resource;
        this.thread = thread;
        Available = new int[resource];
        Max = new int[thread][resource];
        Alloction = new int[thread][resource];
        Need = new int[thread][resource];
        Request = new int[thread][resource];
        Work = new int[resource];
    }


    /**
     * 设置可用资源量
     */
    public void setAvailable(){
        System.out.println("初始系统可用资源量Available：");
        for(int i = 0;i<resource;i++){
            Available[i] = input.nextInt();
        }
    }


    /**
     * 设置各初始系统变量，并判断是否处于安全状态。
     */
    public void setMatrixVariable(){ //设置各类矩阵变量的方法
        setMax();         //调用设置各进程的最大需求矩阵Max
        setAlloction();   //调用各进程分配矩阵Alloction，
        printMatrixVariable();//调用打印设置好的各类矩阵
        Safe();               //调用安全性算法检测
    }


    /**
     * 设置Max矩阵
     */
    public void setMax() {
        System.out.println("请设置各进程的最大需求矩阵Max：");
        for (int i = 0; i < thread; i++) {
            System.out.println("请输入进程P" + i + "的最大资源需求量：");
            for (int j = 0; j < resource; j++) {
                Max[i][j] = input.nextInt();
            }
        }
    }


    /**
     * 设置已分配矩阵Alloction
     */
    public void setAlloction() {
        System.out.println("请设置请各进程分配矩阵Alloction：");
        for (int i = 0; i < thread; i++) {
            System.out.println("请输入进程P" + i + "的分配资源量：");
            for (int j = 0; j < resource; j++) {
                Alloction[i][j] = input.nextInt();
            }
        }
        System.out.println("Available=Available-Alloction.");
        System.out.println("Need=Max-Alloction.");
        for (int i = 0; i < resource; i++) {
            //设置Available矩阵
            for (int j = 0; j < thread; j++) {
                Available[i] = Available[i] - Alloction[j][i];
            }
        }
        for (int i = 0; i < thread; i++) {
            //设置Need矩阵
            for (int j = 0; j < resource; j++) {
                Need[i][j] = Max[i][j] - Alloction[i][j];
            }
        }
    }

    /**
     * 把初始化或设置好的各矩阵打印出来
     */
    public void printMatrixVariable(){
        System.out.println("此时资源分配量如下：");
        System.out.println("进程 \t"+ "Max\t"+"   Alloction\t"+"   Need\t"+ "    Available");
        for(int i=0;i<thread;i++){
            System.out.print("P"+i+"  ");
            for(int j=0; j<resource; j++){
                System.out.print(Max[i][j]+"  ");
            }
            System.out.print("|  ");
            for(int j=0;j<resource;j++){
                System.out.print(Alloction[i][j]+"  ");
            }
            System.out.print("|  ");
            for(int j=0;j<resource;j++){
                System.out.print(Need[i][j]+"  ");
            }
            System.out.print("|  ");
            if(i==0){
                for(int j=0;j<resource;j++){
                    System.out.print(Available[j]+"  ");
                }
            }
            System.out.println();
        }
    }
    /**
     * 设置请求资源量Request
     */
    public void setRequest() {
        System.out.println("请输入请求资源的进程编号：");
        num= input.nextInt();//设置全局变量进程编号num
        System.out.println("请输入请求各资源的数量：");
        for (int j = 0; j < resource; j++) {
            Request[num][j] = input.nextInt();
        }
        BankerAlgorithm();//调用银行家算法
    }

    /**
     * 实现银行家算法功能
     */
    public void BankerAlgorithm() {
        boolean T=true;
        for (int i = 0; i < resource; i++) {
            if (Request[num][i] <= Need[num][i]) {
                if (Request[num][i] <= Available[i]) {
                    Available[i] -= Request[num][i];
                    Alloction[num][i] += Request[num][i];
                    Need[num][i] -= Request[num][i];
                } else {
                    System.out.println("当前没有足够的资源可分配，进程P" + num + "需等待。");
                    T = false;
                }
            } else {
                System.out.println("进程P" + num + "请求已经超出最大需求量Need.");
                T = false;
            }
        }
        if(T==true){
            printMatrixVariable();
            System.out.println("现在进入安全算法：");
            Safe();
        }
    }

    /**
     * 实现安全性检查功能
     */
    public void Safe() {//安全算法
        boolean[] Finish = new boolean[thread];//初始化Finish
        for(int i = 0;i<thread;i++){
            Finish[i] = false;
        }
        int count = 0;  //完成进程数
        int circle= 0;   //循环圈数
        int num1 = 0;
        int[] S=new int[thread]; //安全序列
        for (int i = 0; i < resource; i++) { //设置工作向量
            Work[i] = Available[i];
        }
        System.out.println("进程 \t"+"Work\t"+ " Alloction\t"+"  Need\t"+" Work+Alloction");
        while (count < thread) {
            for (int i = 0; i < thread; i++) {
                for (int a = 0; a < resource; a++) {
                    if (Finish[i] == false && Need[i][a] <= Work[a]) {//判断条件
                        num1++;
                    }
                }
                if(num1 == resource){ //如果该进程的每个资源都满足need<=work,则该进程可以被分配
                    System.out.print("P" + i + "  ");
                    for (int k = 0; k < resource; k++) {
                        System.out.print(Work[k] + "  ");
                    }
                    System.out.print("|  ");
                    for (int j = 0; j < resource; j++) {
                        Work[j] += Alloction[i][j];
                    }
                    Finish[i] = true;//当前进程能满足时
                    S[count] = i;//设置当前序列排号

                    count++;//满足进程数加1
                    for (int j = 0; j < resource; j++) {
                        System.out.print(Alloction[i][j] + "  ");
                    }
                    System.out.print("|  ");
                    for (int j = 0; j < resource; j++) {
                        System.out.print(Need[i][j] + "  ");
                    }
                    System.out.print("|  ");
                    for (int j = 0; j < resource; j++) {
                        System.out.print(Work[j] + "  ");
                    }
                    System.out.println();
                }num1 = 0;

            }

            circle++;//循环圈数加1
            if(count==thread){//判断是否满足所有进程需要
                System.out.print("此时存在一个安全序列：");
                for (int i = 0; i<thread;i++){//输出安全序列
                    System.out.print("P"+S[i]+" ");
                }
                System.out.println("故当前可分配！");
                break;//跳出循环
            }
            if(count<circle){//判断完成进程数是否小于循环圈数
                count=Integer.MAX_VALUE;//设置一个不可能的数跳出循环

                System.out.println("尝试分配后当前系统处于不安全状态，故不存在安全序列。所以应该取消分配！！");

                System.out.println("----------------------------------------------------------------");
                for (int i = 0; i < resource; i++) {
                    Available[i] += Request[num][i]; //如果不存在安全序列就撤销分配
                    Alloction[num][i] -= Request[num][i];
                    Need[num][i] += Request[num][i];
                }
                printMatrixVariable();
                //break;//跳出循环
            }
        }
    }
}
