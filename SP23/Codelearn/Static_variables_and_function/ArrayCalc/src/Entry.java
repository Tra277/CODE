/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alexf
 */
 class ArrayCalculator {
	public static int sumOfArray(int arr[]) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		return sum;
	}

	public static double sumOfArray(double arr[]) {
		double sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		return sum;
	}
}
public class Entry {

    /**
     * @param args the command line arguments
     */
   
    public static void main(String[] args) {
        // TODO code application logic here
        int[] a1 = new int[] {3,4,2};
        double[] a2 = new double[] {3.6 , 5.2,3.7};
        System.out.println(ArrayCalculator.sumOfArray(a1));
         System.out.println(ArrayCalculator.sumOfArray(a2));
       
    }
    
}
