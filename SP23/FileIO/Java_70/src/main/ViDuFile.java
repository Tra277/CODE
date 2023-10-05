package main;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

/**
 *
 * @author alexf
 */
public class ViDuFile {

    /**
     * @param args the command line arguments
     */
    public static void copyAll(File f1, File f2){
        try {
            //copy bản thân nó
            Files.copy(f1.toPath(), f2.toPath(),StandardCopyOption.REPLACE_EXISTING);
            
        } catch (Exception e) {
        }
        if(f1.isDirectory()){
            //Copy cac tap tin va thu muc con
            File[] mangCon = f1.listFiles();
            for (File file : mangCon) {
                File file_new = new File(f2.getAbsoluteFile()+"\\"+file.getName());
                copyAll(file, file_new);
            }
        }
    }
    public static void main(String[] args) {
        // TODO code application logic here
        File f0 = new File("C:\\Users\\alexf\\OneDrive\\Máy tính\\Code\\SP23\\FileIO\\Java_70\\File_1.txt");
        File f1 = new File("C:\\Users\\alexf\\OneDrive\\Máy tính\\Code\\SP23\\FileIO\\Java_70\\File_2.txt");
       File f2 = new File("C:\\Users\\alexf\\OneDrive\\Máy tính\\Code\\SP23\\FileIO\\Java_70\\File_2xyz.txt");
         
     //1. thay đổi tên tập tin và thư mục
        f0.renameTo(f1);
        
     //có thể sử dụng class Files để thay đổi tên
     //hàm move
        try {
            Files.move(f1.toPath(),f2.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
        }
        //2.Di chuyển file
        File f_2new = new File("C:\\Users\\alexf\\OneDrive\\Máy tính\\Code\\SP23\\FileIO\\Java_70\\F0\\File_2xyz.txt");
        try {
            Files.move(f2.toPath(),f_2new.toPath(),StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
        }
        //3.Copy file
        File f_0 = new File("C:\\Users\\alexf\\OneDrive\\Máy tính\\Code\\SP23\\FileIO\\Java_70\\F0");
        File f_0_copy = new File("C:\\Users\\alexf\\OneDrive\\Máy tính\\Code\\SP23\\FileIO\\Java_70\\F0_copy");
        try {
            Files.copy(f_0.toPath(),f_0_copy.toPath(), StandardCopyOption.REPLACE_EXISTING);
            
        } catch (Exception e) {
        }
        //Tuy nhiên lại gặp phải một vài vấn đề ở đây là nó chỉ copy dược cái vỏ bên ngoài chứ không copy được cái ruột
        // ===> phải viết hàm cho trường hợp muốn copy hết 
        ViDuFile.copyAll(f_0, f_0_copy);
    }
    
}
