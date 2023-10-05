package readerManagement;


import mainManagement.Validate;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ReaderList {

    Scanner sc = new Scanner(System.in);
    Validate validate = new Validate();
    NodeReader head, tail;

    public ReaderList() {
        head = tail = null;
    }

    void clear() {
        head = tail = null;
    }

    boolean isEmpty() {
        return (head == null);
    }

    //Display node need visit to console
    void visit(NodeReader needVisit) {
        if (needVisit != null) {
            System.out.print(needVisit.info);
        }
    }

    void addLast(Reader x) {
        NodeReader q = new NodeReader(x);
        if (isEmpty()) {
            head = tail = q;
        } else {
            tail.next = q;
            tail = q;
        }
    }

    // Add new node to the head of list
    void addFirst(Reader x) {
        NodeReader n = new NodeReader(x);
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
        NodeReader current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
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
    public void remove(NodeReader q) {
        if (isEmpty()) {
            return;
        }
        if (q == head) {
            removeFirst();
            return;
        }
        NodeReader f = head;
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

    //2.1
    public void loadFromFile(String filePath) {
        try {
            File readerData = new File(filePath);
            Scanner sc = new Scanner(readerData);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] info = line.split("[|]");
                String name = info[1].trim();
                String rcode = info[0].trim();
                //check duplicate of rcode while reading file
                while (true) {
                    if (this.search(rcode) != null) {
                        System.out.println("Found error with reader named:" + name);
                        System.out.println("The code " + rcode + " is existed !You must give this reader a new code!");
                        rcode = validate.getString("^[A-Za-z][0-9]+$", "");
                    } else {
                        break;
                    }
                }
                //check constrain (1900 <= byear <= 2010)
                int byear = Integer.parseInt(info[2].trim());
                while (true) {
                    if (byear < 1900 || byear > 2010) {
                        System.out.println("Found error with reader named:" + name);
                        System.out.println("birth year must in range between 1900 - 2010 !You must enter this reader a new birth year!");
                        byear = validate.getInt("", "Enter again:", 1900);
                    } else {
                        break;
                    }
                }
                addLast(new Reader(rcode, name, byear));
            }
            sc.close();
           
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    //2.2:Input & add to the end
    public void inputAddlast() {
        //check duplicate bcode
        String rcode;
        while (true) {
            System.out.println("Please enter reader code (VD:R01,R56,...):");
            rcode = validate.getString("^[A-Za-z][0-9]+$", "");
            if (this.search(rcode) == null) {
                break;
            } else {
                System.err.println("Duplicated error! This code is existed !");
            }
        }
        System.out.print("Name of the reader:");
        String name = sc.nextLine().trim();
        //check constrain (1900 <= byear <= 2010)
        System.out.print("Birth year of the reader:");
        int byear = validate.getInt("", "Enter again:", 1900);
        while (true) {
            if (byear < 1900 || byear > 2010) {
                System.out.println("birth year must in range between 1900 - 2010 !Enter again:");
                byear = validate.getInt("", "Enter again:", 1900);
            } else {
                break;
            }
        }
        this.addLast(new Reader(rcode, name, byear));
        this.saveToFile();
    }

    //2.3:Display
    public void Display() {
        if (this.isEmpty()) {
            System.out.println("Nothing to display!");
            //co the nang cap bang viec hoi nguoi dung co muon them phan tu khong
            return;
        }
        System.out.println("code |  Name       |  Birth year");
        System.out.println("=================================");
        NodeReader p = head;
        while (p != null) {
            System.out.println(p.info.toString());
            p = p.next;
        }
    }

    //2.4: save to file
    public void saveToFile() {
        try {
            FileWriter file = new FileWriter("reader.txt");
            NodeReader p = head;
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

    //2.5
    public NodeReader search(String xCode) {
        NodeReader p = head;
        while (p != null) {
            if (p.info.rcode.equals(xCode)) {
                return p;
            }
            p = p.next;
        }
        return null;
    }

    //2.6: delete by rcode
    public void dele(String xCode) {
        try {
            NodeReader nodeNeedDelete = search(xCode);
            this.remove(nodeNeedDelete);
            System.out.println("Delete successfully!");
            this.saveToFile();
        } catch (Exception e) {
            System.out.println("Can't delete!");
        }

    }
}
