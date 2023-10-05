package main;

import java.io.File;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 *
 * @author alexf
 */
public class ViDuXoaFile {

    /**
     * @param args the command line arguments
     */
    //Dùng static để khỏi phải tạo đối tượng
    public static void xoaFile(File fx){
        if(fx.isFile()){
            fx.delete();
        }else if(fx.isDirectory()){
            //hàm listFiles trả về mảng các tập tin và thư mục bên trong
            File[] mangCon = fx.listFiles();
            for (File f : mangCon) {
                //xóa các file con trước
                xoaFile(f);
            }
            
            // tự hủy ( xóa bản thân ) sau khi dùng đệ quy xóa các file con trước đó
            fx.delete();
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        //ý tưởng: ở đây là chúng ta đã tạo cái file đấy trước rồi,cái hàm nầy nó chỉ là tạo đối tượng file dựa trên cái file đấy thôi chứ không phải là tạo file vật lý
        File f0 = new File("C:\\Users\\alexf\\OneDrive\\Máy tính\\Code\\SP23\\FileIO\\Java_69\\F0");
        File f0_1 = new File("C:\\Users\\alexf\\OneDrive\\Máy tính\\Code\\SP23\\FileIO\\Java_69\\F0_1");
        File f_vidu = new File("C:\\Users\\alexf\\OneDrive\\Máy tính\\Code\\SP23\\FileIO\\Java_69\\Vidu");
        
        
        // xóa file: sử dụng hàm delete() or deleteOnExit() --> điều kiện đó phải là một thư mục rỗng mới xóa được
        //delete(): trả về boolean
        //deleteOnExit(): không trả về cái gì hết
        f0_1.deleteOnExit();
        f_vidu.deleteOnExit();// xóa được vì là tập tin, tuy nhiên file đấy đang chạy thì không được 
        
        //làm sao xóa được thư mục không phải rỗng ==> Đệ quy ( xem hàm ở trên )
        ViDuXoaFile.xoaFile(f0);
        
        
//        //Ngoài ra có thể sử dụng class Files (thêm s)
//        Path p0 = f0.toPath();
//        Path p0_1 = f0_1.toPath();
//        Path p_vidu = f_vidu.toPath();
//        try {
//            //Files.deleteIfExists(p0);
//            Files.deleteIfExists(p0_1);
//            Files.deleteIfExists(p_vidu);
//        } catch (Exception e) {
//        }
        
    }
    
}
