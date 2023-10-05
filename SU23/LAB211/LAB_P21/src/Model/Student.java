package Model;

public class Student implements Comparable<Student> {

    private String id;
    private String studentName;
    private String semester;
    private String courseName;

    /**
     * Default constructor for the Student class.
     */
    public Student() {
    }

    /**
     * Constructor for the Student class that takes in values for all fields.
     *
     * @param id the ID of the student
     * @param studentName the name of the student
     * @param semester the semester of the student
     * @param courseName the course name of the student
     */
    public Student(String id, String studentName, String semester, String courseName) {
        this.id = id;
        this.studentName = studentName;
        this.semester = semester;
        this.courseName = courseName;
    }

    /**
     * Returns the ID of the student.
     *
     * @return the ID of the student
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the ID of the student.
     *
     * @param id the new ID of the student
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Returns the name of the student.
     *
     * @return the name of the student
     */
    public String getStudentName() {
        return studentName;
    }

    /**
     * Sets the name of the student.
     *
     * @param studentName the new name of the student
     */
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    /**
     * Returns the semester of the student.
     *
     * @return the semester of the student
     */
    public String getSemester() {
        return semester;
    }

    /**
     * Sets the semester of the student.
     *
     * @param semester the new semester of the student
     */
    public void setSemester(String semester) {
        this.semester = semester;
    }

    /**
     * Returns the course name of the student.
     *
     * @return the course name of the student
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * Sets the course name of the student.
     *
     * @param courseName the new course name of the student
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * Compares this Student object to another Student object based on their
     * names.
     *
     * @param otherStudent another Student object to compare to
     * @return a negative integer if this Student's name comes before
     * otherStudent's name in alphabetical order, a positive integer if this
     * Student's name comes after otherStudent's name in alphabetical order, or
     * 0 if their names are equal
     */
    @Override
    public int compareTo(Student otherStudent) {
        return otherStudent.studentName.compareTo(this.studentName);
    }

    /**
     * Prints out information about this Student object in a formatted manner.
     */
    public void print() {
        System.out.printf("%-15s%-15s%-15s\n", studentName, semester, courseName);
    }

    /**
     * Returns a string representation of the student object.
     *
     * @return a formatted string containing the student's information
     */
    @Override
    public String toString() {
        return String.format("%-15s | %-15s | %-15s | %-15s\n", id, studentName, semester, courseName);
    }

}
