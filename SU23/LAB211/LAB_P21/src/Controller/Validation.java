package Controller;

import Model.Student;
import Model.Report;
import java.util.ArrayList;
import java.util.Scanner;

public class Validation {

    private final static Scanner scanner = new Scanner(System.in);

    /**
     * Checks if the user input is an integer within the given range.
     *
     * @param min the minimum value of the range
     * @param max the maximum value of the range
     * @return an integer within the given range
     */
    public static int checkInputIntLimit(int min, int max) {
        //loop until user input correct
        while (true) {
            try {
                int getValue = Integer.parseInt(scanner.nextLine().trim());
                if (getValue < min || getValue > max) {
                    throw new NumberFormatException();

                }
                return getValue;
            } catch (NumberFormatException e) {
                System.err.println("Please input number in rage [" + min + ", " + max + "]");
                System.out.print("Enter again: ");
            }
        }
    }

    /**
     * Checks if the user input is a non-empty string.
     *
     * @return a non-empty string
     */
    public static String checkInputString() {
        //loop until user input correct
        while (true) {
            String getValue = scanner.nextLine().trim();
            if (getValue.isEmpty()) {
                System.err.println("Not empty");
                System.out.print("Enter again: ");
            } else {
                return getValue;
            }
        }
    }

    /**
     * Checks if the user input is Y/y or N/n.
     *
     * @return true if the user input is Y/y, false if the user input is N/n
     */
    public static boolean checkInputYN() {
        //loop until user input correct
        while (true) {
            String getValue = checkInputString();
            //return true if user input y/Y
            if (getValue.equalsIgnoreCase("Y")) {
                return true;
            }
            //return false if user input n/N
            if (getValue.equalsIgnoreCase("N")) {
                return false;
            }
            System.err.println("Please input y/Y or n/N.");
            System.out.print("Enter again: ");
        }
    }

    /**
     * Checks if the user input is U/u or D/d.
     *
     * @return true if the user input is U/u, false if the user input is D/d
     */
    public static boolean checkInputUD() {
        //loop until user input correct
        while (true) {
            String getValue = checkInputString();
            //return true if user input u/U
            if (getValue.equalsIgnoreCase("U")) {
                return true;
            }
            //return false if user input d/D
            if (getValue.equalsIgnoreCase("D")) {
                return false;
            }
            System.err.println("Please input u/U or d/D.");
            System.out.print("Enter again: ");
        }
    }

    /**
     * Checks if the user input is one of the valid course names.
     *
     * @return a valid course name
     */
    public static String checkInputCourse() {
        //loop until user input correct
        while (true) {
            String getValue = checkInputString();
            //check input course in java/ .net/ c/c++
            if (getValue.equalsIgnoreCase("java")
                    || getValue.equalsIgnoreCase(".net")
                    || getValue.equalsIgnoreCase("c/c++")) {
                return getValue;
            }
            System.err.println("There are only three courses: Java, .Net, C/C++");
            System.out.print("Enter again: ");
        }
    }



        /**
     * Checks if a student with the given information already exists in the list of students.
     *
     * @param listStudent the list of students
     * @param studentID the ID of the student to check for
     * @param studentName the name of the student to check for
     * @param semester the semester of the student to check for
     * @param courseName the course name of the student to check for
     * @return true if a student with the given information does not exist in the list, false otherwise
     */
    public static boolean checkStudentExist(ArrayList<Student> listStudent, String studentID,
                                            String studentName, String semester, String courseName) {
        int size = listStudent.size();
        for (Student student : listStudent) {
            if (studentID.equalsIgnoreCase(student.getId())
                    && studentName.equalsIgnoreCase(student.getStudentName())
                    && semester.equalsIgnoreCase(student.getSemester())
                    && courseName.equalsIgnoreCase(student.getCourseName())) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if a report with the given information already exists in the list of reports.
     *
     * @param listReport the list of reports
     * @param studentName the name of the student to check for
     * @param courseName the course name to check for
     * @param totalCourse the total number of courses to check for
     * @return true if a report with the given information does not exist in the list, false otherwise
     */
    public static boolean checkReportExist(ArrayList<Report> listReport, String studentName,
                                           String courseName, int totalCourse) {
        for (Report report : listReport) {
            if (studentName.equalsIgnoreCase(report.getStudentName())
                    && courseName.equalsIgnoreCase(report.getCourseName())
                    && totalCourse == report.getTotalCourse()) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if a student with the given ID already exists in the list of students.
     *
     * @param listStudent the list of students
     * @param studentID the ID of the student to check for
     * @param studentName the name of the student to check for
     * @return true if a student with the given ID does not exist in the list or has a different name, false otherwise
     */
    public static boolean checkIdExist(ArrayList<Student> listStudent, String studentID, String studentName) {
        for (Student student : listStudent) {
            if (studentID.equalsIgnoreCase(student.getId())
                    && !studentName.equalsIgnoreCase(student.getStudentName())) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if any information about a student has changed.
     *
     * @param student the Student object to compare against
     * @param studentID the new ID of the student
     * @param studentName the new name of the student
     * @param semester the new semester of the student
     * @param courseName the new course name of the student
     * @return true if any information about a student has changed, false otherwise
     */
    public static boolean checkChangeInformation(Student student, String studentID,
                                                String studentName, String semester, String courseName) {
        if (studentID.equalsIgnoreCase(student.getId())
                && studentName.equalsIgnoreCase(student.getStudentName())
                && semester.equalsIgnoreCase(student.getSemester())
                && courseName.equalsIgnoreCase(student.getCourseName())) {
            return false;
        }
        return true;
    }

}

