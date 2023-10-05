/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alexf
 */
class Math{
    public static double PI =3.14;
    
    public static int abs(int x ){
        if(x<0) x = -x;
        return x;
    }
    public static int add(int x,int y){
        return x+y;
    }
    public static int subtract(int x, int y){
        return x-y;
    }
    public static int min(int x , int y){
        return (x>=y)? y : x;
    }
    public static int max(int x, int y){
        return (x>=y)? x : y;
    }
    public static int pow(int x,int y){
        int as=1;
        for (int i=0;i<y;i++) as = as*x;
        return as;
    }
}
public class Entry {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(Math.PI);
		System.out.println(Math.abs(-2));
		System.out.println(Math.add(2, 3));
		System.out.println(Math.subtract(2, 3));
		System.out.println(Math.min(2, 3));
		System.out.println(Math.max(2, 3));
		System.out.println(Math.pow(2, 3));
    }
    
}
