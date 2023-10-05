package binarysearchtree;

public class BSTree {

    Node root;

    BSTree() {
        root = null;
    }

    void clear() {
        root = null;
    }

    boolean isEmpty() {
        return root == null;
    }

    void visit(Node p) {
        if (p != null) {
            System.out.println(p.info + " ");
        }
    }

    void insert(int x) {
        if (isEmpty()) {
            root = new Node(x);
        }
        Node f, p;
        p = root;
        f = null;
        while (p != null) {
            if (p.info == x) {
                System.out.println("The key " + x + " already exist!");
                return;
            }
            f = p;
            if (x < p.info) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        if (x < f.info) {
            f.left = new Node(x);
        } else {
            f.right = new Node(x);
        }
    }

    void insertMany(int a[]) {
        for (int i = 0; i < a.length; i++) {
            insert(a[i]);
        }
    }

}
