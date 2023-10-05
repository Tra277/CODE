
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
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
        list.add(new Person(1, "A"));
        list.add(new Person(5, "A"));
        list.add(new Person(2, "A"));
        list.add(new Person(3, "A"));
        list.add(new Person(6, "A"));
        System.out.println("Trước khi sắp xếp theo id:");
        for (Person person : list) {
            System.out.println(person);
            
        }
        System.out.println("Sau khi sắp xếp:");
        Collections.sort(list);
        for (Person person : list) {
            System.out.println(person);
        }
    }
    
}
