package main;

import java.io.PrintWriter;

/**
 *
 * @author alexf
 */
public class ViDuGhiText {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //ở cái này thì File nó không tồn tại cũng được, thuật toán nó sẽ tự tạo ra mọt file mới
        try {
            PrintWriter pw = new PrintWriter("C:\\Users\\alexf\\OneDrive\\Máy tính\\Code\\SP23\\FileIO\\Java_71\\file.txt","UTF-8");
            pw.println("Xin chào, mình là Sơn Trà Đỗ");
            pw.print("Đây là dữ liệu: ");
            pw.print("kajdshfgkas");
            //Có thể ghi được đối tượng qua phương thức toString();
            Student st = new Student(100, "Nguyen Van A");
            
            pw.println(st);
            
            //!important: đấy dữ liệu vào file
            pw.flush();
            pw.close();
        } catch (Exception e) {
        }
       
    }
    
}
