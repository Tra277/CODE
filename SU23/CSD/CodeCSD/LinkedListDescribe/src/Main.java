public class Main {
    public static void main(String[] args) {
        MyList myList = new MyList();
        myList.addLast(new Person("A", 30));
        System.out.println("My List after addLast: ");
        myList.traversal();
        
        myList.addFirst(new Person("B", 28));
        System.out.println("My List after addFirst: ");
        myList.traversal();
        
        System.out.println("Result search by A");
        myList.searchByName("A");
        
        //Example of addMany
        System.out.println("\nResult list after Addmany person:\n");
        String[] a = {"A","C","B","E","D"};
        int[] b = {9,5,17,5,8};
        myList.addMany(a, b);
        myList.traversal();
    }

}
