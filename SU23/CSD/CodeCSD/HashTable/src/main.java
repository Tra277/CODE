
import java.util.Hashtable;

public class main {
    public static void main(String[] args) {
        Hashtable<Integer,String> tabled  = new Hashtable<>(10);
        tabled.put(100, "Con Cu");
        tabled.put(123, "Patrick");
        tabled.put(321, "Sandy");
        tabled.put(555, "Squidward");
        tabled.put(777, "Gary");
        tabled.put(100, "Con Cu");
        tabled.remove(777);
        for (Integer i : tabled.keySet()) {
            System.out.println(tabled.get(i));
        }
       
    }

}
