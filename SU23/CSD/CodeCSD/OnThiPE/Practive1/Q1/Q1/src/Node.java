// =========== DO NOT EDIT THE GIVEN CONTENT OF THIS FILE ============
// == You can insert setters and/or getters, constructor only if you need them ==== 

class Node {

    Bird info;
    Node next;

    public Node(Bird info, Node next) {
        this.info = info;
        this.next = next;
    }

    public Node(Bird info) {
        this.info = info;
        next = null;
    }

}
