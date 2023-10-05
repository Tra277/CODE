package bookManagement;

public class Book {
    String bcode; // unique
    String title;
    int quantity; // the number of books with same code
    int lended; // lended < quantity
    double price;

    public Book() {
    }

    public Book(String bcode, String title, int quantity, int lended, double price) {
        this.bcode = bcode;
        this.title = title;
        this.quantity = quantity;
        this.lended = lended;
        this.price = price;
    }

    public String getBcode() {
        return bcode;
    }

    public void setBcode(String bcode) {
        this.bcode = bcode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getLended() {
        return lended;
    }

    public void setLended(int lended) {
        this.lended = lended;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    public double getValue(){
       return this.getPrice()*this.getQuantity();
    }
    
    @Override
    public String toString() {
        return String.format("%-5s| %-15s | %-10d | %7d | %-7.1f | %-7.1f\n",this.getBcode(),this.getTitle(),this.getQuantity(),this.getLended(),this.getPrice(),this.getValue() );
    }
    
    
}
