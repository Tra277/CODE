/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Thang
 */
public class ListPhone {

    Node head, tail;

    boolean isEmpty() {
        return head == null;
    }

    void clear() {
        head = null;
    }
    String f0_information(){
        //Assign your RollNumber
        String RollNumber="H124";
        System.out.println(RollNumber);
        return RollNumber;
    }
    
    void f1_addHead(Phone x) {        
       
    }

    void f2_addtail(Phone x) {
        
    }

    Node f3_InsertBefore() {
        Phone x = new Phone("Iphone", "X", 0);
        //insert x before first Phone has max price.
        return head;
    }

    Node f4_InsertAfter() {
        //insert x after last Phone has max price.        
        Phone x = new Phone("Iphone", "X", 0);
       return head;
    }

    Node f5_removeOne() {
        //remove first Phone has price <20
        return head;
    }

    Node f6_removeAll() {
        //remove all Phones have price <20
        return head;
    }

    Node f7_Sort1() {
        //sort list ascending by price
       return head;
    }

    Node f8_sort2() {
        //sort by price increment from head to last max price
       return head;
    }

    void traverse() {
        if (!isEmpty()) {
            Node p = head;
            String s1 = "", s2 = "", s3 = "";
            while (p != null) {
                s1 = p.inf.type;
                s2 = p.inf.model;
                s3 = p.inf.price + "";
                System.out.print("(" + s1 + ", " + s2 + ", " + s3 + ");");
                p = p.next;
            }
            System.out.println("");
        }
    }

}
