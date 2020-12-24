package PageMemory;

/**
 *
 * @author 12640
 */
public class Page {
    private int page;
    private int flag;
    private int piece;
    private int modify;
    private String positionInDisk;

    public Page(int page, int flag, int piece, int modify, String positionInDisk) {

        this.page = page;
        this.flag = flag;
        this.piece = piece;
        this.modify = modify;
        this.positionInDisk = positionInDisk;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public int getPiece() {
        return piece;
    }

    public void setPiece(int piece) {
        this.piece = piece;
    }

    public int getModify() {
        return modify;
    }

    public void setModify(int modify) {
        this.modify = modify;
    }

    public String getPositionInDisk() {
        return positionInDisk;
    }

    public void setPositionInDisk(String positionInDisk) {
        this.positionInDisk = positionInDisk;
    }

}
