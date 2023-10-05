
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Manager {

    private List<Person> pList;

    public Manager() {
        pList = new ArrayList<Person>();
    }

    public void display() {
        if (pList.isEmpty()) {
            System.out.println("Nothing to show");
            return;
        }
        for (Person p : pList) {
            System.out.println(p);
        }
    }

    public void add1Person() {
        Scanner sc = new Scanner(System.in);
        String name;
        int age;
        double salary;
        System.out.println("Enter: ");
        name = sc.nextLine();
        age = sc.nextInt();
        salary = sc.nextDouble();
        pList.add(new Person(name, age, salary));
    }

    //Đọc dữ liệu từ file và ghi vào pList
    public void loadFromFile() throws FileNotFoundException, IOException {
        //File
        //FileReader + BufferedReader
        File f = new File("person.txt");
        if (!f.exists()) {
            System.out.println("New file is created");
            f.createNewFile();
        }
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);

        while (true) {
            String Line = br.readLine();
            if (Line == null) {
                break;
            }
            //Từng phần tử (thuộc tính) sẽ được lưu vào mảng
            String[] info = Line.split("[|]");
            //Xóa bỏ khoảng cách thừa giữa các phần tử
            //lấy được thông tin name
            String name = info[0].trim();
            //lấy được thông tin tuổi
            int age = Integer.parseInt(info[1].trim());
            //lấy được thông tin lương
            double salary = Double.parseDouble(info[2].trim());

            pList.add(new Person(name, age, salary));
        }
        br.close();
        fr.close();
    }

    //Từ pList sẽ tải dữ liệu vào file
    public void saveToFile() throws IOException {
        //File
        //FileWriter + BufferedWriter
        File f = new File("person.txt");
        FileWriter fw = new FileWriter(f);
        BufferedWriter bw = new BufferedWriter(fw);
        for (Person person : pList) {
            bw.write(person.toString() + "\n");
        }

        bw.close();
        fw.close();
    }
}
