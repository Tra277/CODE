package lendingManagement;


import mainManagement.Validate;
import bookManagement.BookList;
import readerManagement.ReaderList;
import java.util.Scanner;

public class LendingList {

    Scanner sc = new Scanner(System.in);
    Validate validate = new Validate();
    BookList bookList = new BookList();
    ReaderList readerList = new ReaderList();

    NodeLending head, tail;

    public LendingList() {
        head = tail = null;
        bookList.loadFromFile("book.txt");
        readerList.loadFromFile("reader.txt");
    }

    void clear() {
        head = tail = null;
    }

    boolean isEmpty() {
        return (head == null);
    }

    //Display node need visit to console
    void visit(NodeLending needVisit) {
        if (needVisit != null) {
            System.out.print(needVisit.info);
        }
    }

    void addLast(Lending x) {
        NodeLending q = new NodeLending(x);
        if (isEmpty()) {
            head = tail = q;
        } else {
            tail.next = q;
            tail = q;
        }
    }

    // Add new node to the head of list
    void addFirst(Lending x) {
        NodeLending n = new NodeLending(x);
        if (isEmpty()) {
            tail = head = n;
        } else {
            n.next = head;
            head = n;
        }
    }

    // size of list
    int size() {
        int count = 0;
        NodeLending current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    //searh node with bcode, rcode
    NodeLending search(String bCode, String rcode) {
        NodeLending p = head;
        while (p != null) {
            if (p.info.bcode.equals(bCode) && p.info.rcode.equals(rcode)) {
                return p;
            }
            p = p.next;
        }
        return null;
    }

    //3.1:Input
    public void inputAddlast() {
        while (true) {
            //check bcode if exists not
            String bcode;
            while (true) {
                System.out.println("Please enter book code (VD:B01,B06,...):");
                bcode = validate.getString("^[A-Za-z][0-9]+$", "");
                if (bookList.search(bcode) == null) {
                    System.err.println("Can find the code of the book, enter again:");
                } else {
                    break;
                }
            }
            //check rcode if exist or not 
            String rcode;
            while (true) {
                System.out.println("Please enter reader code (VD:R01,R56,...):");
                rcode = validate.getString("^[A-Za-z][0-9]+$", "");
                if (readerList.search(rcode) == null) {
                    System.err.println("Can find the code of the reader, enter again:");
                } else {
                    break;
                }
            }
            //Find state,quantity, lended with bcode and rcode
            int state;
            try {
                state = this.search(bcode, rcode).info.state;

            } catch (Exception e) {
                //trong tinh huong null
                state = -1;
            }

            int quality = bookList.search(bcode).info.getQuantity();
            int lended = bookList.search(bcode).info.getLended();
            //check state
            if (state == 1) {
                System.out.println("Data is not accept! Enter other information!");
            } else if (lended == quality) {
                this.addLast(new Lending(bcode, rcode, 0));
                break;
            } else {
                this.addLast(new Lending(bcode, rcode, 1));
                bookList.search(bcode).info.setLended(lended + 1);
                break;
            }
        }

    }

    //3.2:Display
    public void Display() {
        if (this.isEmpty()) {
            System.out.println("Nothing to display!");
            //co the nang cap bang viec hoi nguoi dung co muon them phan tu khong
            return;
        }
        System.out.println("bcode | rcode | state");
        System.out.println("=======================");
        NodeLending p = head;
        while (p != null) {
            System.out.println(p.info.toString());
            p = p.next;
        }
    }

    //3.3: sort by bcode + rcode
    public void sortByBcodeAndRCode() {
        NodeLending pi, pj;
        Lending x;
        for (pi = head; pi != null; pi = pi.next) {
            for (pj = pi.next; pj != null; pj = pj.next) {
                if (pi.info.bcode.compareTo(pj.info.bcode) > 0) {
                    x = pi.info;
                    pi.info = pj.info;
                    pj.info = x;
                } else if (pi.info.bcode.compareTo(pj.info.bcode) == 0) {
                    if (pi.info.rcode.compareTo(pj.info.rcode) > 0) {
                        x = pi.info;
                        pi.info = pj.info;
                        pj.info = x;
                    }
                }
            }
        }
        this.Display();
    }
}
