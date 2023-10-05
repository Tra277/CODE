/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employees;
import java.util.Vector;
import java.util.Scanner;
/**
 *
 * @author ACER
 */
public class Menu extends Vector <String> {
        public Menu() {
            super();
        }
        
        void addMenuItem(String S) {
            this.add(S);
            String elements = this.set(modCount, S);
            System.out.println(elements);
        }
        
        
        public int getUserChoice() {
            Scanner sc = new Scanner(System.in);
            return sc.nextInt();
        }




}
