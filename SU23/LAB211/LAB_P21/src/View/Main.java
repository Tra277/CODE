package View;

import Model.Student;
import Controller.Validation;
import Controller.Manager;
import java.util.ArrayList;

public class Main {
    
    public static void main(String[] args) {
        ArrayList<Student> listStudent = new ArrayList<>();
        Validation validation = new Validation();        
        int countStudent = 0;
        Manager.loadFromFile(countStudent, listStudent);
        //loop until user want to exit program
        while (true) {
            //Show menu option
            Manager.menu();
            int choice = validation.checkInputIntLimit(1, 5);
            switch (choice) {
                case 1:
                    Manager.createStudent(countStudent, listStudent);
                    break;
                case 2:
                    Manager.findAndSort(listStudent);
                    break;
                case 3:
                    Manager.updateOrDelete(countStudent, listStudent);
                    break;
                case 4:
                    Manager.reportStudent(listStudent);
                    break;
                case 5:
                    return;
            }
        }
    }
}
