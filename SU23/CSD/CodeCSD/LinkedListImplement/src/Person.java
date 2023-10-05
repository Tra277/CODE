public class Person {
    private String nameString;
    private int age;

    public Person(String nameString, int age) {
        this.nameString = nameString;
        this.age = age;
    }

    public String getNameString() {
        return nameString;
    }

    public void setNameString(String nameString) {
        this.nameString = nameString;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" + "nameString=" + nameString + ", age=" + age + '}';
    }
    
    
}
