package Model;

public class Report {

    private String studentName;
    private String courseName;
    private int totalCourse;

    /**
     * Default constructor for the Report class.
     */
    public Report() {
    }

    /**
     * Constructor for the Report class that takes in values for all fields.
     *
     * @param studentName the name of the student
     * @param courseName the name of the course
     * @param totalCourse the total number of courses
     */
    public Report(String studentName, String courseName, int totalCourse) {
        this.studentName = studentName;
        this.courseName = courseName;
        this.totalCourse = totalCourse;
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
     * Returns the name of the course.
     *
     * @return the name of the course
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * Sets the name of the course.
     *
     * @param courseName the new name of the course
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * Returns the total number of courses.
     *
     * @return the total number of courses
     */
    public int getTotalCourse() {
        return totalCourse;
    }

    /**
     * Sets the total number of courses.
     *
     * @param totalCourse the new total number of courses
     */
    public void setTotalCourse(int totalCourse) {
        this.totalCourse = totalCourse;
    }
}
