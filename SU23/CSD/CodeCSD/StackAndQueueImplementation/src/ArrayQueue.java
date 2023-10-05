public class ArrayQueue {

    private int capacity;
    private int[] data;
    private int front;
    private int rear;
    private int size;

    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        data = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public void enqueue(int value) {
        if (size == capacity) {
            expandCapacity();
        }
        rear = (rear + 1) % data.length;
        data[rear] = value;
        size++;
    }

    public int dequeue() {
        if (size == 0) {
            throw new IllegalStateException("Queue is empty");
        }
        int value = data[front];
        front = (front + 1) % data.length;
        size--;
        return value;
    }

    public int peek() {
        if (size == 0) {
            throw new IllegalStateException("Queue is empty");
        }
        return data[front];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private void expandCapacity() {
        int newCapacity = capacity * 2;
        int[] newData = new int[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
        capacity = newCapacity;
    }
}
