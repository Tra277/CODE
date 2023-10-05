package main;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alexf
 */
public class ViDuTaoTapTinVaThuMuc {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //MS Windows: \ => \\
        // Kiểm tra thư mục hay tập tin có tồn tại hay không
        File folder1 = new File("C:\\Users\\alexf\\OneDrive\\Máy tính\\Code\\FileIO\\Java_67");
        System.out.println("Kiểm tra folder1 có tồn tại hay không: "+folder1.exists());
        //Tạo thư mục
        //phương thức mkdir() => tạo 1 thư mục
        File d1 = new File("C:\\Users\\alexf\\OneDrive\\Máy tính\\Code\\FileIO\\Java_67\\Directory_1");
        d1.mkdir();
        
        //phương thức mkdirs() => tạo nhiều thư mnucj cùng lúc
         File d2 = new File("C:\\Users\\alexf\\OneDrive\\Máy tính\\Code\\FileIO\\Java_67\\Directory_1\\Directory_2\\Directory_3");
        d2.mkdirs();
        
        //Tạo tập tin (có phần mở rộng:.exe,.txt,.doc,.xls...)
        File file1 = new File("C:\\Users\\alexf\\OneDrive\\Máy tính\\Code\\FileIO\\Java_67\\Directory_1\\Vidu1.txt");
        try {
            file1.createNewFile();
            //Nếu file này đã tồn tại rồi thì không tạo file mới nữa
        } catch (IOException ex) {
            //Không có quyền tạo tập tin
            // Ổ cứng bị đầy
            // Đường dẫn bị sai
            //Luôn bỏ vào try catch
            Logger.getLogger(ViDuTaoTapTinVaThuMuc.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
