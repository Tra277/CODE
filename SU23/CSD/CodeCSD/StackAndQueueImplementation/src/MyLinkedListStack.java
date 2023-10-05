
import java.util.ArrayList;


public class MyLinkedListStack  {

    private class Node {

        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }
    Node head;

    public MyLinkedListStack() {
        head = null;

    }

    
    public boolean push(int value) {
        if (!isFull()) {
            Node newNode = new Node(value);
            newNode.next = head;
            head = newNode;
            return true;
        }
        return false;
    }

    
    public int pop() {
        if (isEmpty()) {
            return -1;
        }
        int value = head.value;
        head = head.next;
        return value;
    }

    
    public boolean isFull() {
        return false;
    }

    
    public boolean isEmpty() {
        return head == null;
    }

   
    public void show() {
        if(isEmpty()){
            System.out.println("List is Empty");
        }
        
        Node temp = head;
        ArrayList<Integer> tempList = new ArrayList<>();
        while(temp != null){
            //System.out.print(temp.value+" ");
            tempList.add(temp.value);
            temp = temp.next;
        }
        for(int i=tempList.size()-1;i>=0;i--){
            System.out.print(tempList.get(i)+" ");
        }
        System.out.println("");
    }

}
