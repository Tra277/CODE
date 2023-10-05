package readerManagement;

public class NodeReader {
    Reader info;
    NodeReader next;

    public NodeReader() {
    }

    public NodeReader(Reader info, NodeReader next) {
        this.info = info;
        this.next = next;
    }

    public NodeReader(Reader info) {
        this(info,null);
    }
    
    
}
