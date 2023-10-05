
/**
 *
 * @author alexf
 */
public class Person {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Person(int id) {
        this.id = id;
    }

    
    @Override
    public boolean equals(Object obj) {
       return (obj instanceof Person) ? (((Person) obj).getId()== this.id):false;
    }
    

   
    
    
}
