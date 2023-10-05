public class ArrayStack {

    private int[] data;
    private int size;
    private int capacity;

    public ArrayStack() {
        data = new int[10];
        size = 0;
        capacity = 10;
    }

    public void push(int value) {
        if (size == capacity) {
            expandCapacity();
        }
        data[size++] = value;
    }

    public int pop() {
        if (size == 0) {
            throw new IllegalStateException("Stack is empty");
        }
        return data[--size];
    }

    public int peek() {
        if (size == 0) {
            throw new IllegalStateException("Stack is empty");
        }
        return data[size - 1];
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
