
/**
 *
 * @author alexf
 */
public class SpecCoffee extends Coffee{
    private int price;

    public SpecCoffee() {
    }

    public SpecCoffee( String name, int size,int price) {
        super(name, size);
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return this.getName()+","+this.getSize()+","+this.getPrice();
    }
    
    public void setData(){
        setName("CF"+this.getName());
    }
    
    public int getValue(){
        if(this.getSize()>10){
            return this.getPrice();
        }else{
            return this.getPrice()+5;
        }
    }
    
    
    
}
