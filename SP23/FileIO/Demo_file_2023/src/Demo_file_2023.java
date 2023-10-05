
import java.io.IOException;

public class Demo_file_2023 {
    public static void main(String[] args) throws IOException {
        Manager m = new Manager();
        m.loadFromFile();
        m.add1Person();
        m.add1Person();
        m.display();
       m.saveToFile();
    }

}
