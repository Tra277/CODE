
import java.util.ArrayList;
import java.util.Iterator;
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
        List<String> list = new ArrayList<String>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("E");
        list.add("D");
        
        
        
        Iterator<String> itr = list.iterator();
        while(itr.hasNext()){
            String s = itr.next();
            if(s.equals("A")){
                itr.remove();
            }
            
        }
        for (String string : list) {
            System.out.println(string);
        }
    }
    
}
