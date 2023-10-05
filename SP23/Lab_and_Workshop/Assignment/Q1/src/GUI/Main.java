package GUI;

import Utility.Utility;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author HP
 */
public class Main {
    public static void main(String[] args) throws IOException {
        SubjectList subjectList = new SubjectList();
        subjectList.loadFromFile("C:\\JAVA\\subjects.txt");
       
        StudentList studentList = new StudentList();
        studentList.loadFromFile("C:\\JAVA\\students.txt");
        
        MarkList markList = new MarkList();
        markList.loadFromFile("C:\\JAVA\\Marks.txt");
        
        Utility u = new Utility();
        Scanner sc = new Scanner(System.in);
        int choice;

        System.out.println("1. Add/Edit a student");
        System.out.println("2. Add/Edit a subject");
        System.out.println("3. Add/Edit a subject's marks for the given student");
        choice = u.getInt(sc, "Enter your choice: 1, 2, or 3:", 1, 3);
        switch(choice)
            {
                case 1:
                    studentList.addEdit(sc); 
                    System.out.println("OUTPUT:");
                    studentList.display();
                    break;
                case 2:                    
                    subjectList.addEdit(sc);
                    System.out.println("OUTPUT:");
                    subjectList.display();
                    break;
                case 3:
                    markList.addEdit(sc);
                    System.out.println("OUTPUT:");
                    markList.display();
                    break;
            }
                
    }
    
}
