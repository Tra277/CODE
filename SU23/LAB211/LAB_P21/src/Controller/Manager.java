package Controller;

import Model.Report;
import Model.Student;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Manager {

    /**
     * Displays the main menu.
     */
    public static void menu() {
        System.out.println(" 1.	Create");
        System.out.println(" 2.	Find and Sort");
        System.out.println(" 3.	Update/Delete");
        System.out.println(" 4.	Report");
        System.out.println(" 5.	Exit");
        System.out.print(" Enter your choice: ");
    }

    /**
     * Loads student data from a file and adds it to the given list of students.
     *
     * @param countStudent the number of students in the list
     * @param listStudent the list of students to add the data to
     */
    public static void loadFromFile(int countStudent, ArrayList<Student> listStudent) {
        try {
            // Create a File object for the Students.txt file
            File studentData = new File("Students.txt");
            // Create a Scanner to read from the file
            Scanner scanner = new Scanner(studentData);
            // Read each line from the file
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Split the line into an array of strings
                String[] infoStudent = line.split("[|]");
                // Extract the student information from the array
                String studentID = infoStudent[0].trim();
                String studentName = infoStudent[1].trim();
                String semester = infoStudent[2].trim();
                String courseName = infoStudent[3].trim();
                // Create a new Student object and add it to the list
                listStudent.add(new Student(studentID, studentName, semester, courseName));
                countStudent++;
            }
            // Close the scanner
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Saves the given list of students to a file.
     *
     * @param countStudent the number of students in the list
     * @param listStudent the list of students to save to the file
     */
    public static void saveToFile(ArrayList<Student> listStudent) {
        try {
            // Create a FileWriter object for the Students.txt file
            FileWriter fileToSave = new FileWriter("Students.txt");
            // Write each student to the file
            for (Student student : listStudent) {
                fileToSave.write(student.toString());
            }
            // Close the FileWriter
            fileToSave.close();
        } catch (IOException e) {
            System.out.println("An error occur!");
        }
    }

    /**
     * Allows the user to create a new student.
     *
     * @param countStudent the current number of students
     * @param listStudent the list of students
     */
    public static void createStudent(int countStudent, ArrayList<Student> listStudent) {
        //if number of students greater than 10 ask user continue or not
        if (countStudent > 10) {
            System.out.print("Do you want to continue (Y/N): ");
            if (!Validation.checkInputYN()) {
                return;
            }
        }
        //loop until user input not duplicate
        while (true) {
            System.out.print("Enter studentID: ");
            String studentID = Validation.checkInputString();
            System.out.print("Enter name student: ");
            String studentName = Validation.checkInputString();
            if (!Validation.checkIdExist(listStudent, studentID, studentName)) {
                System.err.println("studentID has exist student. Pleas re-input.");
                continue;
            }
            System.out.print("Enter semester: ");
            String semester = Validation.checkInputString();
            System.out.print("Enter name course: ");
            String courseName = Validation.checkInputCourse();
            if (Validation.checkStudentExist(listStudent, studentID, studentName, semester, courseName)) {
                listStudent.add(new Student(studentID, studentName, semester, courseName));
                countStudent++;
                System.out.println("Add student success.");
                saveToFile(listStudent);
                return;
            }
            System.err.println("Duplicate.");
            
        }
    }

    /**
     * Finds and sorts students by name.
     *
     * @param listStudent the list of students
     */
    public static void findAndSort(ArrayList<Student> listStudent) {
        if (listStudent.isEmpty()) {
            System.err.println("List empty.");
            return;
        }
        ArrayList<Student> listStudentFindByName = listStudentFindByName(listStudent);
        if (listStudentFindByName.isEmpty()) {
            System.err.println("Not exist.");
        } else {
            Collections.sort(listStudentFindByName);
            System.out.printf("%-15s%-15s%-15s\n", "Student name", "semester", "Course Name");
            //loop from first to last element of list student
            for (Student student : listStudentFindByName) {
                student.print();
            }
        }
    }

    /**
     * Returns a list of students whose names contain the given search string.
     *
     * @param listStudent the list of students
     * @return an ArrayList of Student objects whose names contain the given
     * search string
     */
    public static ArrayList<Student> listStudentFindByName(ArrayList<Student> listStudent) {
        ArrayList<Student> listStudentFindByName = new ArrayList<>();
        System.out.print("Enter name to search: ");
        String studentName = Validation.checkInputString();
        for (Student student : listStudent) {
            if (student.getStudentName().contains(studentName)) {
                listStudentFindByName.add(student);
            }
        }
        return listStudentFindByName;
    }

    /**
     * Allows the user to update or delete a student.
     *
     * @param countStudent the current number of students
     * @param listStudent the list of students
     */
    public static void updateOrDelete(int countStudent, ArrayList<Student> listStudent) {
        if (listStudent.isEmpty()) {
            System.err.println("List empty.");
            return;
        }
        System.out.print("Enter studentID: ");
        String studentID = Validation.checkInputString();
        ArrayList<Student> listStudentFindByName = getListStudentById(listStudent, studentID);
        if (listStudentFindByName.isEmpty()) {
            System.err.println("Not found student.");
            return;
        } else {
            Student student = getStudentByListFound(listStudentFindByName);
            System.out.print("Do you want to update (U) or delete (D) student: ");
            if (Validation.checkInputUD()) {
                System.out.print("Enter studentID: ");
                String idStudent = Validation.checkInputString();
                System.out.print("Enter name student: ");
                String name = Validation.checkInputString();
                System.out.print("Enter semester: ");
                String semester = Validation.checkInputString();
                System.out.print("Enter name course: ");
                String courseName = Validation.checkInputCourse();
                if (!Validation.checkChangeInformation(student, studentID, name, semester, courseName)) {
                    System.err.println("Nothing change.");
                }
                if (Validation.checkStudentExist(listStudent, studentID, name, semester, courseName)) {
                    student.setId(idStudent);
                    student.setStudentName(name);
                    student.setSemester(semester);
                    student.setCourseName(courseName);
                    System.err.println("Update success.");
                }
                return;
            } else {
                listStudent.remove(student);
                countStudent--;
                System.err.println("Delete success.");
                saveToFile(listStudent);
                return;
            }
        }
    }

    /**
     * Returns a Student object selected by the user from a given list of
     * students.
     *
     * @param listStudentFindByName the list of students to choose from
     * @return the Student object selected by the user
     */
    public static Student getStudentByListFound(ArrayList<Student> listStudentFindByName) {
        System.out.println("List student found: ");
        int countStudent = 1;
        System.out.printf("%-10s%-15s%-15s%-15s\n", "Number", "Student name",
                "semester", "Course Name");
        for (Student student : listStudentFindByName) {
            System.out.printf("%-10d%-15s%-15s%-15s\n", countStudent,
                    student.getStudentName(), student.getSemester(),
                    student.getCourseName());
            countStudent++;
        }
        System.out.print("Enter student: ");
        int choice = Validation.checkInputIntLimit(1, listStudentFindByName.size());
        return listStudentFindByName.get(choice - 1);
    }

    /**
     * Returns a list of students whose IDs match the given ID.
     *
     * @param listStudent the list of students
     * @param studentID the ID to search for
     * @return an ArrayList of Student objects whose IDs match the given ID
     */
    public static ArrayList<Student> getListStudentById(ArrayList<Student> listStudent, String studentID) {
        ArrayList<Student> getListStudentById = new ArrayList<>();
        for (Student student : listStudent) {
            if (studentID.equalsIgnoreCase(student.getId())) {
                getListStudentById.add(student);
            }
        }
        return getListStudentById;
    }

    /**
     * Generates a report of the number of courses taken by each student.
     *
     * @param listStudent the list of students
     */
    public static void reportStudent(ArrayList<Student> listStudent) {
        if (listStudent.isEmpty()) {
            System.err.println("List empty.");
            return;
        }
        LinkedHashMap<String, Report> reportMap = new LinkedHashMap<>();
        for (Student student : listStudent) {
            String studentID = student.getId();
            String courseName = student.getCourseName();
            String studentName = student.getStudentName();
            String key = studentID + courseName;
            if (reportMap.containsKey(key)) {
                Report report = reportMap.get(key);
                report.setTotalCourse(report.getTotalCourse() + 1);
            } else {
                reportMap.put(key, new Report(studentName, courseName, 1));
            }
        }
        for (Report report : reportMap.values()) {
            System.out.printf("%-15s|%-10s|%-5d\n", report.getStudentName(),
                    report.getCourseName(), report.getTotalCourse());
        }
    }
}
