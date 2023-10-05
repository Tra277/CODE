package lendingManagement;

public class NodeLending {
    Lending info;
    NodeLending next;

    public NodeLending() {
    }

    public NodeLending(Lending info, NodeLending next) {
        this.info = info;
        this.next = next;
    }

    public NodeLending(Lending info) {
        this(info,null);
    }
    
    
}
