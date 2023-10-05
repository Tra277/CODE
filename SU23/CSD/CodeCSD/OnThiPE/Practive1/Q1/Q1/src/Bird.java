// == You can insert setters and/or getters, constructor, toString only if you need them ==== 

class Bird {

    String owner;
    int price, color;

    public Bird() {
    }

    public Bird(String owner, int price, int color) {
        this.owner = owner;
        this.price = price;
        this.color = color;
    }
    
    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "("+this.getOwner()+","+this.getPrice()+","+this.getColor()+")";
    }
    
    

}
