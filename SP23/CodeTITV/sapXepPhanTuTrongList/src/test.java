
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 *
 * @author alexf
 */
public class test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        List<String> listString = new ArrayList<String>();
        listString.add("a");
        listString.add("d");
        listString.add("c");
        listString.add("b");
        for (String string : listString) {
            System.out.println(string);
        }
              System.out.println("Sau khi sap xep tang dan:");
              Collections.sort(listString);
              for (String string : listString) {
                  System.out.println(string);
            
        }
              List<Integer> list = new ArrayList<Integer>();
              list.add(1);
              list.add(10);
               list.add(6);
              list.add(5);
               list.add(9);
              list.add(4);
              for (Integer integer : list) {
                  System.out.println(integer);
        }
              System.out.println("Sau khi sap xep");
              Collections.sort(list);
              for (Integer integer : list) {
                  System.out.println(integer);
        }
    }
    
}
