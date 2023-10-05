
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MyList l = new MyList();
        List<Person> pr = new ArrayList<Person>();
        
        pr.add(new Person("Anh", 20));
        pr.add(new Person("Anh", 20));
        pr.add(new Person("Anh", 20));
        pr.add(new Person("Anh", 20));
        pr.add(new Person("Anh", 20));
        l.addMany(pr);
        l.traverse();
        l.clear();
        
        Person x = new Person("ANH",20);
        l.addMany(pr);
        l.addHead(x);
        l.traverse();
    }

}
