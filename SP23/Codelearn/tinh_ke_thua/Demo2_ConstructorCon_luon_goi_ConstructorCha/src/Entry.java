class Person{
	private String name;
	private int dob;
	public Person(String name, int dob) {
		this.name = name;
		this.dob = dob;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDob() {
		return dob;
	}
	public void setDob(int dob) {
		this.dob = dob;
	}
}

class Student extends Person {
	private double gpa;

	public Student(String name, int dob, double gpa) {
		// Gọi tới constructor 2 tham số của lớp cha
                //khi lớp cha không có constructor mặc định mà lớp con không 
                //chỉ rõ cần gọi tới constructor nào của lớp cha 
                //thì chương trình sẽ báo lỗi
		super(name, dob);//super(name) chính là gọi tới constructor một tham số của lớp cha.
		this.gpa = gpa;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
}

public class Entry {
	public static void main(String[] args) {
		Student s = new Student("Hai", 1999, 8.8);
		System.out.println("Name: " + s.getName());
		System.out.println("Date of birth: " + s.getDob());
		System.out.println("GPA: " + s.getGpa());
	}
}