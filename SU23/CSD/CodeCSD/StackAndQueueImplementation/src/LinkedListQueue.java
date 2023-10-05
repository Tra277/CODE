public class LinkedListQueue {

    private Node front;
    private Node rear;
    private int size;

    public LinkedListQueue() {
        front = null;
        rear = null;
        size = 0;
    }

    public void enqueue(int value) {
        Node newNode = new Node(value);
        if (rear == null) {
            front = newNode;
        } else {
            rear.next = newNode;
        }
        rear = newNode;
        size++;
    }

    public int dequeue() {
        if (front == null) {
            throw new IllegalStateException("Queue is empty");
        }
        int value = front.value;
        front = front.next;
        size--;
        if (front == null) {
            rear = null;
        }
        return value;
    }

    public int peek() {
        if (front == null) {
            throw new IllegalStateException("Queue is empty");
        }
        return front.value;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
            next = null;
        }
    }
}
