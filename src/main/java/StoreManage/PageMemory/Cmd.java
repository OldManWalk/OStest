package StoreManage.PageMemory;

public class Cmd {
    private String operation;
    private int page;
    private String addressInPage;

    public Cmd(String operation, int page, String addressInPage) {
        super();
        this.operation = operation;
        this.page = page;
        this.addressInPage = addressInPage;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getAddressInPage() {
        return addressInPage;
    }

    public void setAddressInPage(String addressInPage) {
        this.addressInPage = addressInPage;
    }

}
