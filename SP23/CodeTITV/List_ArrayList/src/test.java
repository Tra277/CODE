
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author alexf
 */
public class test {

   
    public static void main(String[] args) {
        // TODO code application logic here
        Person p1 = new Person(1);
        Person p2 = new Person(2);
        Person p3 = new Person(3);
        List<Person> danhSach = new ArrayList<Person>();
        danhSach.add(p1);
        danhSach.add(p3);
        danhSach.add(p2);
        // Lấy ra một phần tử
        Person p = danhSach.get(1);
        System.out.println(p.getId());
        
        //In ra phần tử dùng vòng lặp
        for (Person person : danhSach) {
            System.out.println(person.getId());
        }
        for (int i = 0; i < danhSach.size(); i++) {
            System.out.println(danhSach.get(i).getId());
        }
        //xóa phần tử
        danhSach.remove(p1);
    }
    
}
