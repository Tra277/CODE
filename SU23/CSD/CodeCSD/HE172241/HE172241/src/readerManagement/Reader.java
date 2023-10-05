package readerManagement;

public class Reader {
    String rcode; // unique for the reader
    String name;
    int byear; // nam sinh cua nguoi doc ( 1900 <= byear <= 2010);

    public Reader() {
    }

    public Reader(String rcode, String name, int byear) {
        this.rcode = rcode;
        this.name = name;
        this.byear = byear;
    }

    public String getRcode() {
        return rcode;
    }

    public void setRcode(String rcode) {
        this.rcode = rcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getByear() {
        return byear;
    }

    public void setByear(int byear) {
        this.byear = byear;
    }

    @Override
    public String toString() {
        return String.format("%-5s| %-10s | %d\n",this.getRcode(),this.getName(),this.getByear() );
    }
    
}
