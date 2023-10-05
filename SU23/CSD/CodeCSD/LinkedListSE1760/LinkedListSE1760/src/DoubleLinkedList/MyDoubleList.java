package DoubleLinkedList;

public class MyDoubleList {

    DoubleNode head, tail;

    public MyDoubleList() {
    }

    void clear() {
        head = tail = null;
    }

    boolean isEmpty() {
        return (head == null);
    }

    //Display node need visit to console
    void visit(DoubleNode needVisit) {
        if (needVisit != null) {
            System.out.print(needVisit.info);
        }
    }

    //(3)- Traverse and display all node of list
    void traverse() {
        DoubleNode p = head;
        while (p != null) {
            System.out.print(p.info + " ");
            p = p.next;
        }
        System.out.println();
    }

    void addLast(Person x) {
        DoubleNode p = new DoubleNode(x);
        if (isEmpty()) {
            head = tail = p;
        } else {
            tail.next = p;
            p.prev = tail;
            tail = p;
        }
    }

    void addFirst(Person x) {
        DoubleNode q = new DoubleNode(x);
        if (isEmpty()) {
            head = tail = q;
        } else {
            q.next = head;
            head.prev = q;
            head = q;
        }
    }

    void addMany(String a[], int b[]) {
        for (int i = 0; i < a.length; i++) {
            addLast(new Person(a[i], b[i]));
        }
    }

    DoubleNode searchByName(String xName) {
        DoubleNode current = head;
        while (current != null) {
            if (current.info.name.equals(xName)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public void insertAfter(DoubleNode q, Person x) {
        DoubleNode newNode = new DoubleNode(x);
        newNode.next = q.next; 
        newNode.prev = q; 
        if (q.next != null) { 
            q.next.prev = newNode; 
        }
        q.next = newNode; 
    }

    void insertBefore(DoubleNode needInsertBefore, Person x) {
        DoubleNode newNode = new DoubleNode(x); 
        newNode.prev = needInsertBefore.prev; 
        newNode.next = needInsertBefore; 
        if (needInsertBefore.prev != null) { 
            needInsertBefore.prev.next = newNode; 
        }
        needInsertBefore.prev = newNode; 
    }

    public void remove(DoubleNode q) {
        if (q.prev != null) { 
            q.prev.next = q.next; 
        } else { 
            head = q.next; 
        }
        if (q.next != null) { 
            q.next.prev = q.prev; 
        }
    }
}
