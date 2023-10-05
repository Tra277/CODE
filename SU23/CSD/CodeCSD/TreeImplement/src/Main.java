
public class Main {

    public static void main(String[] args) {
        BSTree t = new BSTree();

        int[] a = {8, 3, 10, 1, 6, 14, 4, 7, 13};
        t.insertMany(a);
        System.out.println("1.Test pre-oder traversal:");
        t.preOrder(t.root);
        System.out.println();

        System.out.println("2.Test in-oder traversal:");
        t.inOrder(t.root);
        System.out.println();

        System.out.println("3.Test post-oder traversal:");
        t.postOrder(t.root);
        System.out.println();

        System.out.println("4.Test breadth-first traversal:");
        t.breadth(t.root);
        System.out.println();

        //Xoa
        System.out.println("5.Test delete by copying:");
        t.deleByCopy(10);
        t.breadth(t.root);
        System.out.println();
        
        System.out.println("6.Test balance the tree :");
        t.balanceCallback();
        t.breadth(t.root);
        System.out.println();
    }

}
