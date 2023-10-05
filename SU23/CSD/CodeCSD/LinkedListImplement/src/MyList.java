
import java.util.List;

public class MyList {

    Node head, tail;

    public MyList() {
    }

    boolean Empty() {
        return head == null;
    }

    void clear() {
        
    }

    void addHead(Person x) {
        Node p = new Node(x);
        if (Empty()) {
            head = tail = null;
        } else {
            p.next = head;
            head = p;
        }
    }

    void addLast(Person x) {
        Node p = new Node(x);
        if (Empty()) {
            head = tail = p;
        } else {
            tail.next = p;
            tail = p;
        }

    }

    void addMany(List<Person> pr) {
        for (int i = 0; i < pr.size(); i++) {
            addLast(pr.get(i));
        }
    }

    void display(Node p) {
        if (p != null) {
            System.out.println(p.info + " ");
        }
    }

    //duyet danh sach
    void traverse() {
        Node p = head;
        while (p != null) {
            display(p);
            p = p.next;
        }
    }
    
    void addIndex(Person x){
        
    }
}
