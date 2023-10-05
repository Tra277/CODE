package DoubleLinkedList;
public class Main {
    public static void main(String[] args) {
        MyDoubleList db = new MyDoubleList();
        DoubleNode p, q;
        Person x;
        int k;
        String[] a = {"A", "C", "B", "E", "D"};
        int[] b = {9, 5, 17, 5, 8};
        //Checked
        System.out.println("\n1. Test addLast");
        db.clear();
        db.addMany(a, b);
        db.traverse(); //  (A,9) (C,5) (B,17) (E,5) (D,8)
        x = new Person("X", 30);
        db.addLast(x);
        db.traverse();

        //Checked
        System.out.println("\n2. Test addFirst");
        db.clear();
        db.addMany(a, b);
        db.traverse(); //  (A,9) (C,5) (B,17) (E,5) (D,8)
        x = new Person("X", 30);
        db.addFirst(x);
        db.traverse(); // (X,30) (A,9) (C,5) (B,17) (E,5) (D,8)
    }

}
