
public class MyList {

    Node head, tail;

    //khi khởi tạo một danh sách rỗng thì head = tail = null
    public MyList() {
        head = tail = null;
    }

    //check nếu danh sách có rỗng hay không, chỉ cần head or tail null thì danh sách rỗng
    public boolean isEmpty() {
        return head == null;
    }

    //làm rỗng danh sách, list không có head và tail thì sẽ là list rỗng
    public void clear() {
        head = tail = null;
    }

    //hàm thăm và in ra phần tử
    public void visit(Node p) {
        if (p != null) {
            System.out.println(p.data);
        }
    }

    //hàm duyệt danh sách
    public void traversal() {
        //khởi tạo nốt p trỏ đến vị trí đầu tiên của phần tử
        Node p = head;
        while (p != null) {
            visit(p);
            //trỏ đến node tiếp theo trong List
            p = p.next;
        }
        System.out.println();
    }

    //thêm phần tử vào cuối danh sách
    public void addLast(Person x) {
        Node p = new Node(x);
        //Kiểm tra xem list có rỗng không,có thì head và tail sẽ trả về là nốt p
        if (isEmpty()) {
            head = tail = p;
            return;
        }
        //next của nốt cuối được trỏ đến nốt thêm vào
        tail.next = p;
        //nốt cuối mới sẽ là p
        tail = p;
    }

    //thêm phần tử vào đầu danh sách
    public void addFirst(Person x) {
        Node p = new Node(x);
        //Kiểm tra xem list có rỗng không,có thì head và tail sẽ trả về là nốt p
        if (isEmpty()) {
            head = tail = p;
            return;
        }
        //next của p được trỏ tới node head
        p.next = head;
        //node head mới sẽ là p
        head = p;
    }

    //Thêm nhiều phần tử cùng lúc
    public void addMany(String[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            addLast(new Person(a[i], b[i]));
        }
    }

    //Chèn một node vào sau node q
    public void insertAfter(Node q, Person x) {
        if (q == null) {
            return;
        }

        //khởi tạo phần tử sau node q
        Node qNext = q.next;
        //Khởi tạo node cần thêm
        Node p = new Node(x, qNext);
        //next của node q được trỏ tới phần tử thêm vào
        q.next = p;
        if (tail == q) {
            tail = p;
        }

    }

    //Chèn một node vào trước node q 
    public void insertBefore(Node q, Person x) {
        if (q == null) {
            return;
        }

        if (q == head) {
            addFirst(x);
            return;
        }

        Node f = head;
        while (f != null && f.next != q) {
            f = f.next;
        }

        if (f == null) {
            //q không nằm trong danh sách
            return;
        }
        insertAfter(f, x);
    }

    //hàm tìm kiếm phần tử theo tên của Person
    public Node searchByName(String name) {
            Node p = head;
        //trả về false nếu không tìm thấy phần tử         
        while (p != null) {
            if (p.data.name.equals(name)) {
                return p;
            }
            //chuyển sang node khác
            p = p.next;
        }
        return null;
    }
    
    public Node searchByAge(int age){
        Node p = head;
        //trả về false nếu không tìm thấy phần tử         
        while (p != null) {
            if (p.data.age == age) {
                return p;
            }
            //chuyển sang node khác
            p = p.next;
        }
        return null;
    }

    //xóa phần tử ở đầu danh sách
    public void removeFirst() {
        if (isEmpty()) {
            return;
        }

        //Gán lại phần tử đầu bằng phần tử tiếp theo
        head = head.next;
        if (head == null) {
            tail = null;
        }
    }

    //xóa 1 node
    public void remove(Node q) {
        if (isEmpty()) {
            return;
        }
        if (q == head) {
            removeFirst();
            return;
        }

        Node qNext = q.next;

        Node f = head;
        while (f != null && f.next != q) {
            f = f.next;
        }
        if (f == null) {
            //q không nằm trong danh sách
            return;
        }
        f.next = qNext;

        if (f.next == null) {
            tail = f;
        }
    }

    //xóa bỏ 1 phần tử theo tên
    void removeName(String xName) {
        Node p = searchByName(xName);
        remove(p);
    }

    //xóa bỏ một phần tử theo tuổi
    void removeAge(String xAge) {
        Node p = head;
        while (p != null) {
            if (p.data.name.equals(xAge)) {
                remove(p);
                //Chỉ xóa bỏ một phần tử xong break
                break;
            }
        }
    }

}
