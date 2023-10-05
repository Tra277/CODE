
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alexf
 */
public class ArbitraryDemo {
    public double sum(double... group){
        double S=0;
        for(double x:group) S+=x;
        return S;
    }
    public String concate(String... group){
        String S="";
        for (String x: group) S+=x +" ";
        return S;
    }
    
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        ArbitraryDemo obj = new ArbitraryDemo();
        double total = obj.sum(5.4,3.2,9.08,4);
        System.out.println(total);
        String line = obj.concate("I","Fuck","You","!");
        System.out.println(line);
    }
    
}
