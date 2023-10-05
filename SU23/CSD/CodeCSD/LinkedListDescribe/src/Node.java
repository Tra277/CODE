
public class Node {
    //data is an instance of Person, have attribute like name,age
    //next is an instance(object) of Node
    Person data;
    Node next;

    public Node() {
    }

    public Node(Person data, Node next) {
        this.data = data;
        this.next = next;
    }

    public Node(Person data) {
        this.data = data;
        this.next = null;
    }
    
}
