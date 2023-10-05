package readafile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadAFile {
    public static void main(String[] args) {
        //we use the Scanner class to read the contents of the text file we created in the previous chapter
        try {
            File myObj = new File("filename.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {                
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
