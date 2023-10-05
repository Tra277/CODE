/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alexf
 */
class Car{
    private String Colour;
    private int EnginePower;
    private boolean Convertible;
    private boolean parkingBrake;

    public Car() {
        Colour="";
        EnginePower=0;
        Convertible=false;
        parkingBrake=false;
    }
    
    public Car(String Colour, int EnginePower, boolean Convertible, boolean parkingBrake) {
        this.Colour = Colour;
        this.EnginePower = EnginePower;
        this.Convertible = Convertible;
        this.parkingBrake = parkingBrake;
    }
    public void pressStartButton(){
        System.out.println("You can press the start button");
    }
    public void pressAcceleratorButton(){
        System.out.println("You can press the accelerator button");
        System.out.println("Colour:"+Colour);
        System.out.println("Engine power:"+EnginePower);
        System.out.println("Convertible:"+Convertible);
        System.out.println("parking brake:"+parkingBrake);
       
    }

    public void setColour(String Colour) {
        this.Colour = Colour;
    }

    public String getColour() {
        return Colour;
    }

    public void setEnginePower(int EnginePower) {
        this.EnginePower = EnginePower;
    }

    public int getEnginePower() {
        return EnginePower;
    }

    public void setConvertible(boolean Convertible) {
        this.Convertible = Convertible;
    }

    public void setParkingBrake(boolean parkingBrake) {
        this.parkingBrake = parkingBrake;
    }

    public boolean isConvertible() {
        return Convertible;
    }

    public boolean isParkingBrake() {
        return parkingBrake;
    }

    public void output() {
        System.out.println("Colour:"+getColour());
        System.out.println("EnginePower:"+getEnginePower());
        System.out.println("Convertible:"+isConvertible());
        System.out.println("ParkingBrake:"+isParkingBrake());
    }
    
}
public class Tester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Car c=new Car();
        c.pressStartButton(); 
        c.pressAcceleratorButton();
        c.output(); 
 
 
        Car c2=new Car("red", 100, true, true);
        c2.pressAcceleratorButton();
        c2.setColour("black");
        System.out.println("Colour of c2:" + c2.getColour());
        c2.output();

    }
    
}
