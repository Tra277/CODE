class Person{
	public Person() {
		System.out.println("Person constructor");
	}
}

class Student extends Person{
	public Student() {
		System.out.println("Student constructor");
	}
}

class Entry {
	public static void main(String[] args) {
		Student s = new Student();
	}
}