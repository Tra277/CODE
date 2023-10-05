package bookManagement;

public class NodeBook {
    public Book info;
    public NodeBook next;

    public NodeBook() {
    }

    public NodeBook(Book info, NodeBook next) {
        this.info = info;
        this.next = next;
    }

    public NodeBook(Book info) {
        this(info,null);
    }
    
    
}
