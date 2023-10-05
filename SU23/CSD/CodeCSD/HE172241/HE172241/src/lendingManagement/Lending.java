package lendingManagement;


public class Lending {

    String bcode; // foreign key from Book ?
    String rcode; // foreign key from Reader class ?
    int state; // trang thai ? 0: chua cho muon , 1 : dang muon, chua tra
    //2. da duoc tra lai thu vien

    public Lending() {
    }

    public Lending(String bcode, String rcode, int state) {
        this.bcode = bcode;
        this.rcode = rcode;
        this.state = state;
    }

    public String getBcode() {
        return bcode;
    }

    public void setBcode(String bcode) {
        this.bcode = bcode;
    }

    public String getRcode() {
        return rcode;
    }

    public void setRcode(String rcode) {
        this.rcode = rcode;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return String.format("%-5s| %-5s | %d",this.getBcode(),this.getRcode(),this.getState() );
    }
    
    
}
