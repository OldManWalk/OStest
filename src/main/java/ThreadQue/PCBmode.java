package ThreadQue;

/**
 *     ddTime 到达时间
 *     runTime运行所需时间
 *     statue运行状态
 *     zx执行时间
 */
public class PCBmode {
    String name;
    int Super;
    int zxTime;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSuper() {
        return Super;
    }

    public void setSuper(int aSuper) {
        Super = aSuper;
    }

    public int getZxTime() {
        return zxTime;
    }

    public void setZxTime(int zxTime) {
        this.zxTime = zxTime;
    }

    public int getDdTime() {
        return ddTime;
    }

    public void setDdTime(int ddTime) {
        this.ddTime = ddTime;
    }

    public int getRunTime() {
        return runTime;
    }

    public void setRunTime(int runTime) {
        this.runTime = runTime;
    }

    public String getStatue() {
        return statue;
    }

    public void setStatue(String statue) {
        this.statue = statue;
    }

    int ddTime;
    int runTime;
    String statue;
}
