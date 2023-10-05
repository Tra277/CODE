
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


/**
 *
 * @author alexf
 */
public class Main {

    /**
     * @param args the command line arguments
     */
   
    public static void main(String[] args) {
        // TODO code application logic here
        List<Person> list = new ArrayList<Person>();
        list.add(new Person(1, "a"));
        list.add(new Person(5, "d"));
        list.add(new Person(3, "c"));
        list.add(new Person(2, "b"));
        list.add(new Person(7, "e"));
        
        System.out.println("Truoc khi sap xep:");
        for (Person person : list) {
            System.out.println(person);
        }
        System.out.println("Sau khi sap xep:");
        Collections.sort(list, new Comparator<Person>(){
           @Override
            public int compare(Person o1, Person o2) {
               if(o1.getId()>o2.getId()){
                   return 1;
               } else if(o1.getId()<o2.getId()){
                   return -1;
               } else {
                   return 0;
               }
            }
    
        });
        for (Person person : list) {
            System.out.println(person);
        }
    }
   

     
}
