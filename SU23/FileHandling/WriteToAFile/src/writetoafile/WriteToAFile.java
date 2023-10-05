package writetoafile;

import java.io.FileWriter;
import java.io.IOException;

public class WriteToAFile {
    public static void main(String[] args) {
        try {
            try (FileWriter myWriter = new FileWriter("filename.txt")) {
                myWriter.write("File trong java vui vloz");
            }
            System.out.println("Successfully write to a file!");
        } catch (IOException e) {
            System.out.println("An occur error!");
        }
    }

}
