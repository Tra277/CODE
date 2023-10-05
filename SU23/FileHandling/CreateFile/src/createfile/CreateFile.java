package createfile;

import java.io.File;
import java.io.IOException;

public class CreateFile {
    public static void main(String[] args) {
        try {
            File myObj = new File("filename.txt");
            if(myObj.createNewFile()){
                System.out.println("File create: "+myObj.getName());
            }else{
                System.out.println("File da ton tai");
            }
        } catch (IOException e) {
            System.err.println("Loi.");
            e.printStackTrace();;
        }
    }

}
