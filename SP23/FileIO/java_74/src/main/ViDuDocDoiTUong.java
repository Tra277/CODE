package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class ViDuDocDoiTUong {
    public static void main(String[] args) {
           try {
            File file = new File("C:\\Users\\alexf\\OneDrive\\Máy tính\\Code\\SP23\\FileIO\\java_74\\file.data");
            InputStream is = new FileInputStream(file);
            //Tạo đối tượng để ghi dữ liệu xuống file
            ObjectInputStream ois = new ObjectInputStream(is);
            SinhVien st = (SinhVien) ois.readObject();
               System.out.println(st);
          
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
