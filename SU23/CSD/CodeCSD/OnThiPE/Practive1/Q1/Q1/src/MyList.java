/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.util.*;
import java.io.*;

public class MyList {

    Node head, tail;

    MyList() {
        head = tail = null;
    }

    boolean isEmpty() {
        return (head == null);
    }

    void clear() {
        head = tail = null;
    }

    void fvisit(Node p, RandomAccessFile f) throws Exception {
        if (p != null) {
            f.writeBytes(p.info + " ");
        }
    }

    void ftraverse(RandomAccessFile f) throws Exception {
        Node p = head;
        while (p != null) {
            fvisit(p, f); // You will use this statement to write information of the node p to the file
            p = p.next;
        }
        f.writeBytes("\r\n");
    }

    void loadData(int k) { //do not edit this function
        String[] a = Lib.readLineToStrArray("data.txt", k);
        int[] b = Lib.readLineToIntArray("data.txt", k + 1);
        int[] c = Lib.readLineToIntArray("data.txt", k + 2);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            addLast(a[i], b[i], c[i]);
        }
    }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
    void addLast(String xOwner, int xPrice, int xColor) {//You should write here appropriate statements to complete this function.
//        if (xOwner.charAt(0) == 'B' || xPrice > 7) {
//            return;
//        }
        Node q = new Node(new Bird(xOwner, xPrice, xColor));
        if (isEmpty()) {
            head = tail = q;
        } else {
            tail.next = q;
            tail = q;
        }
    }

    void addFirst(Bird x) {
        Node n = new Node(x);
        if (isEmpty()) {
            tail = head = n;
        } else {
            n.next = head;
            //cập nhật head mới bằng n
            head = n;
        }
    }

    public void removeFirst() {
        if (isEmpty()) {
            return;
        }

        head = head.next;
        if (head == null) {
            tail = null;
        }
    }

    // (6) - Remove node from the list
    public void remove(Node q) {
        if (isEmpty()) {
            return;
        }
        if (q == head) {
            removeFirst();
            return;
        }
        Node f = head;
        while (f != null && f.next != q) {
            f = f.next;
        }
        if (f == null) {
            return;
        }
        f.next = q.next;

        if (f.next == null) {
            tail = f;
        }
    }

    //You do not need to edit this function. Your task is to complete the addLast function above only.
    void f1() throws Exception {
        clear();
        loadData(1);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        f.close();
    }

//==================================================================

    /*
    •	void f2() – There are 2 given Bird objects x, y in this function. Suppose the list contains at least 5 elements. Write statements to insert x and y to the list so that x will be the 1st (head), y will be the 2nd element in the list. Output in the file f2.txt must be the following:
(C,9,8) (D,6,3) (E,8,5) (F,5,4) (I,4,9) 
(X,1,2) (Y,3,4) (C,9,8) (D,6,3) (E,8,5) (F,5,4) (I,4,9)

     */
    void f2() throws Exception {
        clear();
        loadData(5);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        Bird x = new Bird("X", 1, 2);
        Bird y = new Bird("Y", 3, 4);
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        addFirst(y);
        addFirst(x);
        // end of your statements
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

//==================================================================

    /*
    void f3() — Suppose the list is not empty. Remove the first node having price < 6. Output
    in the file f3.txt must be the following:
    (C,8,6) (D,6,7) (E,9,2) (F,5,8) (G,9,7) (H,6,8) (I,7,3)
    (C,8,6) (D,6,7) (E,9,2) (G,9,7) (H,6,8) (I,7,3)
     */
    void f3() throws Exception {
        clear();
        loadData(9);
        String fname = "f3.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        int count = 1;
        Node p = head;

        while (p != null) {
            if (p.info.price < 9 && !"ABCDEF".contains(p.info.owner)) {
                if (count == 2) {
                    remove(p);
                    break;
                }
                count++;
            }

            p = p.next;
        }
        // end of your statements
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

//==================================================================
    void f4() throws Exception {
        clear();
        loadData(13);
        String fname = "f4.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/

        // end your statement
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }
}
