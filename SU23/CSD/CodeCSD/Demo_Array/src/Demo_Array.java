
import java.util.Scanner;

public class Demo_Array {

    public static Scanner scanner = new Scanner(System.in);

    public static void inputArr(int a[], int n) {
        //nhập giá trị các phần tử của mảng
        System.out.println("Enter the elements of the array");
        for (int i = 0; i < n; i++) {
            System.out.print("a[" + i + "] = ");
            a[i] = scanner.nextInt();
        }
    }

    public static void showArr(int a[], int n) {
        System.out.println("\nShow array:");
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + ", ");
        }
    }

    //thêm phần tử vào cuối dãy
    public static void insertLast(int a[], int n, int value) {

        a[n - 1] = value;
        n++;

    }

    //thêm phần tử vào đầu dãy
    public static void insertFirst(int a[], int n, int value) {
        for (int i = n; i > 0; i--) {
            a[i] = a[i - 1];
        }
        a[0] = value;
    }

    //tìm kiếm phần tử theo giá trị
    public static int searchIndex(int a[], int n, int value) {
        for (int i = 0; i < n; i++) {
            if (a[i] == value) {
                return i;
            }
        }
        return -1;
    }

    //xóa phần tử theo vị trị mảng
    public static void deleteIndex(int a[], int n, int index) {
        for (int i = index; i < n - 1; i++) {
            a[i] = a[i + 1];
        }
        a[n - 1] = 0;
        showArr(a, n - 1);
    }

    public static void main(String[] args) {

        int n;

        //nhập số phần tử của mảng
        System.out.print("Enter n: ");
        n = scanner.nextInt();
        int a[] = new int[n];

        inputArr(a, n);
        showArr(a, n);
        deleteIndex(a, n, 2);
        insertLast(a, n, 6);
        showArr(a, n);

        //show value at index
        System.out.println("\nEnter the value you want to search:");
        int Value = scanner.nextInt();
        System.out.println("Found " + Value + " at index: " + searchIndex(a, n, Value));
        ;
    }

}
