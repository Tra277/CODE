package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;


public class ViDuDocFile {

   
    public static void main(String[] args) throws IOException {
        //lệnh để tạo một đối tượng để đọc file trong java
        //nên tạo một cái path riêng cho đỡ nhầm lẫn ( chắc thế =))))
       
        //CÁCH 1:
    /*    File f = new File("C:\\Users\\alexf\\OneDrive\\Máy tính\\Code\\SP23\\FileIO\\Java_72\\file.txt");
        try {
            BufferedReader br = Files.newBufferedReader(f.toPath(),StandardCharsets.UTF_8);
            String line = null;
            while(true){
                line = br.readLine();
                if (line==null) {
                    break;
                 
                }else{
                    System.out.println(line);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        */
        
        //CÁCH 2:
        File f2 = new File("C:\\Users\\alexf\\OneDrive\\Máy tính\\Code\\SP23\\FileIO\\Java_72\\file.txt");
        try {
            List<String> allText = Files.readAllLines(f2.toPath(),StandardCharsets.UTF_8);
            for (String string : allText) {
                System.out.println(string);
            }
        } catch (Exception e) {
        }
        
    }
    
}
