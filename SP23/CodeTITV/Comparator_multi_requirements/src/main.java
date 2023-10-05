
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author alexf
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
           List<Person> list = new ArrayList<Person>();
        list.add(new Person(3, "A",20));
        list.add(new Person(1, "E",18));
        list.add(new Person(2, "G",25));
        list.add(new Person(4, "B",30));
        list.add(new Person(5, "S",21));
        
        System.out.println("Truoc khi sap xep:");
        for (Person person : list) {
            System.out.println(person);
        }
        list.sort((p1,p2) -> {
            
        };
    }
    
}
