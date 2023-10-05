package main;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class ViDuGhiObject {
    public static void main(String[] args) {
        //Cách lưu, ghi đối tượng vào tập tin
        //class: OutPutStream
        //Mục tiêu bài này:làm thêm một chức năng là ghi danh sách sinh viên vào tệp tin
        try {
            File file = new File("C:\\Users\\alexf\\OneDrive\\Máy tính\\Code\\SP23\\FileIO\\java_73\\file.data");
            OutputStream os = new FileOutputStream(file);
            //Tạo đối tượng để ghi dữ liệu xuống file
            ObjectOutputStream oos = new ObjectOutputStream(os);
            SinhVien st = new SinhVien("001", "TITV", 2000, (float) 10.0);
            oos.writeObject(st);
            oos.flush();
            oos.close();
        } catch (Exception e) {
        }

        //OutputStream ở đây là một inter
    }

}
