package bookManagement;

import mainManagement.Validate;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class BookList {

    Scanner sc = new Scanner(System.in);
    Validate validate = new Validate();

    NodeBook head, tail;

    public BookList() {
        head = tail = null;
    }

    void clear() {
        head = tail = null;
    }

    boolean isEmpty() {
        return (head == null);
    }

    //Display node need visit to console
    void visit(NodeBook needVisit) {
        if (needVisit != null) {
            System.out.print(needVisit.info);
        }
    }

    void addLast(Book x) {
        NodeBook q = new NodeBook(x);
        if (isEmpty()) {
            head = tail = q;
        } else {
            tail.next = q;
            tail = q;
        }
    }

    // Add new node to the head of list
    void addFirst(Book x) {
        //tao nut moi
        NodeBook n = new NodeBook(x);
        if (isEmpty()) {
            tail = head = n;
        } else {
            //noi head vao sau n
            n.next = head;
            //cap nhat head moi bang n
            head = n;
        }
    }

    // size of list
    int size() {
        int count = 0;
        NodeBook current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    // Add new node after current node
    public void insertAfter(NodeBook q, Book x) {
        if (q == null) {
            return;
        }
        NodeBook qNext = q.next;
        NodeBook p = new NodeBook(x, qNext);
        q.next = p;
        if (tail == q) {
            tail = p;
        }

    }

    //  Add new node before current node
    void insertBefore(NodeBook needInsertBefore, Book x) {
        if (needInsertBefore == null) {
            return;
        }
        NodeBook f = head;
        while (f != null && f.next != needInsertBefore) {
            f = f.next;
        }

        if (f == null) {
            return;
        }

        insertAfter(f, x);

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

    // Remove node from the list
    public void remove(NodeBook q) {
        if (isEmpty()) {
            return;
        }
        if (q == head) {
            removeFirst();
            return;
        }
        NodeBook f = head;
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

    // Return node at the position index
    NodeBook pos(int k) {
        if (isEmpty() || k < 0) {
            return null;
        }
        NodeBook current = head;
        int count = 0;
        while (current != null) {
            if (count == k) {
                return current;
            }
            count++;
            current = current.next;
        }
        return null;
    }

    //1.1: load data from file and add to BookList
    public void loadFromFile(String filePath) {
        try {
            File bookData = new File(filePath);
            Scanner sc = new Scanner(bookData);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] info = line.split("[|]");
                String title = info[1].trim();
                String bcode = info[0].trim();
                //check duplicate while reading file
                while (true) {
                    if (this.search(bcode) != null) {
                        System.out.println("Found error with book named:" + title);
                        System.out.println("The code " + bcode + " is existed !You must give this book a new code!");
                        bcode = validate.getString("^[A-Za-z][0-9]+$", "");
                    } else {
                        break;
                    }
                }
                int quantity = Integer.parseInt(info[2].trim());
                double price = Double.parseDouble(info[3].trim());
                addLast(new Book(bcode, title, quantity, 0, price));
            }
            sc.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    //1.2:input and add to the end
    public void inputAddlast() {
        //check duplicate bcode
        String bcode;
        while (true) {
            System.out.println("Please enter book code (VD:B01,B56,...):");
            bcode = validate.getString("^[A-Za-z][0-9]+$", "");
            if (this.search(bcode) == null) {
                break;
            } else {
                System.err.println("Duplicated error! This code is existed !");
            }
        }
        System.out.print("Title of the book:");
        String title = sc.nextLine().trim();
        int quantity = validate.getInt("Please enter the quantity:", "must be greater than 0", 0);
        //check constrain of lended
        int lended;
        do {
            lended = validate.getInt("Please enter the number of this book has lended:", "must be greater than 0", 0);
        } while (lended > quantity);

        double price = validate.getDouble("Please enter the price of the book:", "must be greater than 0", 0);
        this.addLast(new Book(bcode, title, quantity, lended, price));
        this.saveToFile();
    }

    //1.3:Display
    public void Display() {
        if (this.isEmpty()) {
            System.out.println("Nothing to display!");
            //co the nang cap bang viec hoi nguoi dung co muon them phan tu khong
            return;
        }
        System.out.println("code |   Title         |  Quantity  |  Lended |  Price   |   Value");
        System.out.println("=================================================================");
        NodeBook p = head;
        while (p != null) {
            System.out.println(p.info.toString());
            p = p.next;
        }
    }

    //1.4:Save book list to file
    public void saveToFile() {
        try {
            FileWriter file = new FileWriter("book.txt");
            NodeBook p = head;
            while (p != null) {
                file.write(p.info.toString());
                p = p.next;
            }
            System.out.println("Successfully write to file!");
            file.close();
        } catch (IOException e) {
            System.out.println("An error occur!");
        }
    }

    //1.5:search by bcode
    public NodeBook search(String xCode) {
        NodeBook p = head;
        while (p != null) {
            if (p.info.bcode.equals(xCode)) {
                return p;
            }
            p = p.next;
        }
        return null;
    }

    //1.6: delete by bcode
    public void dele(String xCode) {
        try {
            NodeBook nodeNeedDelete = search(xCode);
            this.remove(nodeNeedDelete);
            System.out.println("Delete successfully");
            this.saveToFile();
        } catch (Exception e) {
            System.out.println("Can't delete!");
        }

    }

    //1.7:sort by bcode
    public void sortByBcode() {
        NodeBook pi, pj;
        Book x;
        for (pi = head; pi != null; pi = pi.next) {
            for (pj = pi.next; pj != null; pj = pj.next) {
                if (pi.info.bcode.compareTo(pj.info.bcode) > 0) {
                    x = pi.info;
                    pi.info = pj.info;
                    pj.info = x;
                }
            }
        }
    }

    //1.8:Input & add to beginning
    public void inputAddFirst() {
        //check duplicate bcode
        String bcode;
        while (true) {
            System.out.println("Please enter book code (VD:B01,B56,...):");
            bcode = validate.getString("^[A-Za-z][0-9]+$", "");
            if (this.search(bcode) == null) {
                break;
            } else {
                System.err.println("Duplicated error! This code is existed !");
            }
        }
        System.out.print("Title of the book:");
        String title = sc.nextLine().trim();
        int quantity = validate.getInt("Please enter the quantity:", "must be greater than 0", 0);
        //check constrain of lended
        int lended;
        do {
            lended = validate.getInt("Please enter the number of this book has lended:", "must be greater than 0", 0);
        } while (lended > quantity);

        double price = validate.getDouble("Please enter the price of the book:", "must be greater than 0", 0);
        this.addFirst(new Book(bcode, title, quantity, lended, price));
        this.saveToFile();
    }

    //1.9:
    public void inputAddBefore(int k) {
        //check duplicate bcode
        String bcode;
        while (true) {
            System.out.println("Please enter book code (VD:B01,B56,...):");
            bcode = validate.getString("^[A-Za-z][0-9]+$", "");
            if (this.search(bcode) == null) {
                break;
            } else {
                System.err.println("Duplicated error! This code is existed !");
            }
        }
        System.out.print("Title of the book:");
        String title = sc.nextLine().trim();
        int quantity = validate.getInt("Please enter the quantity:", "must be greater than 0", 0);
        //check constrain of lended
        int lended;
        do {
            lended = validate.getInt("Please enter the number of this book has lended:", "must be greater than 0", 0);
        } while (lended > quantity);

        double price = validate.getDouble("Please enter the price of the book:", "must be greater than 0", 0);
        this.insertBefore(this.pos(k), new Book(bcode, title, quantity, lended, price));
        this.saveToFile();
    }

    //1.10: delete position k
    // Remove node at index using above function
    public void removePos(int k) {
        NodeBook nodeToRemove = pos(k);
        if (nodeToRemove != null) {
            remove(nodeToRemove);
        }
        this.saveToFile();
    }
}
