/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employees;

import java.util.Scanner;

/**
 *
 * @author ACER
 */
public class ManagerProgram {
    public static void main(String[] args) {
        String filename = "employee.txt";
        Scanner sc = new Scanner(System.in);
        Menu menu = new Menu();
        menu.add("Add new employee");
        menu.add("Remove an employee");
        menu.add("Promoting the employee's salary");
        menu.add("Print the list");
        menu.add("Save to files");
        menu.add("Quit");
        int userChoice;
        boolean changed = false;
        EmpList list = new EmpList();
        list.AddFromFile(filename);// load initial data
        System.out.println("1. Add new employee");
        System.out.println("2. Remove an employee");
        System.out.println("3. Promoting the employee's salary");
        System.out.println("4. Print the list");
        System.out.println("5. Save to files");
        System.out.println("6. Quit");
        do {
            System.out.println("\nEMPLOYEE MANAGER");
            userChoice = menu.getUserChoice();
            switch (userChoice) {
                case 1: list.addNewEmp(); changed = true; break;
                case 2: list.removeEmp(); changed = true; break;
                case 3: list.promote(); changed = true; break;
                case 4: list.print(); break;
                case 5: list.saveToFile(filename); changed = false;
                default : if (changed) {
                    System.out.print("Save changes Y/N? ");
                    String response = sc.nextLine().toUpperCase();
                    if (response.startsWith("Y")) {
                        list.saveToFile(filename);
                    } else {
                        System.out.println("Canceled");
                    }
                }
            }
        } while (userChoice>0 && userChoice<6);
    }
}
