package DTO;

/**
 *
 * @author alexf
 */
public class Mark {
    private String studentID;
    private String subjectID;
    private double marks;

    public Mark() {
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(String subjectID) {
        this.subjectID = subjectID;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    public Mark(String studentID, String subjectID, double marks) {
        this.studentID = studentID;
        this.subjectID = subjectID;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Mark{" + "studentID=" + studentID + ", subjectID=" + subjectID + ", marks=" + marks + '}';
    }
    
}
