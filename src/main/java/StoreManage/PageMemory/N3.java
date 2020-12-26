package StoreManage.PageMemory;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class N3 {
    private static int L;
    private static int j;
    private static int m = 4;
    private static int k = 0;
    private static int P[] = { 0, 1, 2, 3 };

    private static List<Page> pageList = new ArrayList<Page>();
    private static List<Cmd> cmdList = new ArrayList<Cmd>();

    public static void main(String[] args) {

        Page page0 = new Page(0, 1, 5, 0, "011");
        Page page1 = new Page(1, 1, 8, 0, "012");
        Page page2 = new Page(2, 1, 9, 0, "013");
        Page page3 = new Page(3, 1, 1, 0, "021");
        Page page4 = new Page(4, 0, -1, 0, "022");
        Page page5 = new Page(5, 0, -1, 0, "023");
        Page page6 = new Page(6, 0, -1, 0, "121");
        pageList.add(page0);
        pageList.add(page1);
        pageList.add(page2);
        pageList.add(page3);
        pageList.add(page4);
        pageList.add(page5);
        pageList.add(page6);
        Cmd cmd0 = new Cmd("+", 0, "070");
        Cmd cmd1 = new Cmd("+", 1, "050");
        Cmd cmd2 = new Cmd("x", 2, "015");
        Cmd cmd3 = new Cmd("存", 3, "021");
        Cmd cmd4 = new Cmd("取", 0, "056");
        Cmd cmd5 = new Cmd("-", 6, "040");
        Cmd cmd6 = new Cmd("移位", 4, "053");
        Cmd cmd7 = new Cmd("+", 5, "023");
        Cmd cmd8 = new Cmd("存", 1, "037");
        Cmd cmd9 = new Cmd("取", 2, "078");
        Cmd cmd10 = new Cmd("+", 4, "001");
        Cmd cmd11 = new Cmd("存", 6, "084");
        cmdList.add(cmd0);
        cmdList.add(cmd1);
        cmdList.add(cmd2);
        cmdList.add(cmd3);
        cmdList.add(cmd4);
        cmdList.add(cmd5);
        cmdList.add(cmd6);
        cmdList.add(cmd7);
        cmdList.add(cmd8);
        cmdList.add(cmd9);
        cmdList.add(cmd10);
        cmdList.add(cmd11);
        printPageList();
        while (!cmdList.isEmpty()) {
            // 取指令中访问的页号＝＞L
            L = cmdList.get(0).getPage();

            while (true) {
                // 查页表
                // 页标志=1
                if (pageList.get(L).getFlag() == 1) {
                    // 形成绝对地址
                    int absoluteAddress = pageList.get(L).getPiece() * 1024
                            + Integer.parseInt(cmdList.get(0).getAddressInPage());

                    // 是”存”指令
                    if (cmdList.get(0).getOperation().equalsIgnoreCase("存")) {
                        // 置L页修改标志”1”
                        pageList.get(L).setModify(1);

                    } else {
                    }

                    // 输出绝对地址
                    System.out.println("运行指令:" + cmdList.get(0).getOperation() + "\t页号:" + pageList.get(L).getPage()
                            + "        页内地址:" + cmdList.get(0).getAddressInPage() + "        绝对地址:" + absoluteAddress
                            + "        页标志:" + pageList.get(L).getFlag() + "        主存块号:" + pageList.get(L).getPiece()
                            + "        页修改标志:" + pageList.get(L).getModify() + "        页在磁盘上的位置:"
                            + pageList.get(L).getPositionInDisk());

                }
                // 页标志!=1
                else {
                    System.out.println();
                    System.out.println("内存中找不到页" + L);

                    j = P[k];
                    int tempPiece = pageList.get(j).getPiece();

                    if (pageList.get(j).getModify() == 1) {
                        System.out.println("页" + 3 + "写到外存");
                    } else {
                    }
                    System.out.println("内存调出页" + j);
                    pageList.get(j).setFlag(0);
                    pageList.get(j).setModify(0);
                    pageList.get(j).setPiece(-1);
                    System.out.println("内存调入页" + L);
                    pageList.get(L).setFlag(1);
                    pageList.get(L).setPiece(tempPiece);
                    P[k] = L;
                    k = (k + 1) % m;
                    printPageList();
                    continue;
                }
                // 当前指令结束
                cmdList.remove(0);
                break;
            }
        }
    }

    private static void printPageList() {
        System.out.println("==========================================================================");
        System.out.print("页号\t标志\t主存块号\t修改标志\t在磁盘上的位置\n");
        // finish链
        for (Page page : pageList)
            System.out.println(page.getPage() + "\t" + page.getFlag() + "\t" + page.getPiece() + "\t" + page.getModify()
                    + "\t" + page.getPositionInDisk());
        System.out.println("==========================================================================");

    }

}
