//Khai báo lớp trừu tượng Animal
abstract class Animal{
    //Tính chất 2:Phương thức trừu tượng là phương thức mà chỉ có phần khai báo, không có phần thân
    public abstract void makeSound();

}

class Cat extends Animal{
    //Tính chất 3:Nếu một lớp được kế thừa từ lớp trừu tượng thì lớp đó phải ghi đè tất cả các phương thức trừu tượng
    @Override
	public void makeSound() {
		System.out.println("meow meow");
	}
}

public class Entry {
	public static void main(String[] args) {
                //Tính chất 1:Chỉ có thể khởi tạo ở lớp con chứ không khởi tạo được ở lớp trừu tượng
                Animal a = new Cat();
                a.makeSound();
        }
}