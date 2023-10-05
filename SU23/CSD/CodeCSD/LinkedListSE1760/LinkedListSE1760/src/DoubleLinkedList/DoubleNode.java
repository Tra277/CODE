package DoubleLinkedList;
public class DoubleNode {
     Person info;
     DoubleNode prev;
    DoubleNode next;

    public DoubleNode() {
    }

    public DoubleNode(Person info, DoubleNode prev, DoubleNode next) {
        this.info = info;
        this.prev = prev;
        this.next = next;
    }

    public DoubleNode(Person info) {
        this.info = info;
        this.prev = null;
        this.next = null;
    }
    
    
}
