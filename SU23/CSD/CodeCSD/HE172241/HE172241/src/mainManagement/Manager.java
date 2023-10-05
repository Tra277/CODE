package mainManagement;


import bookManagement.BookList;
import readerManagement.ReaderList;
import lendingManagement.LendingList;
import java.util.Scanner;

class Manager {

    LendingList lendngList = new LendingList();
    BookList bookList = new BookList();
    ReaderList readerList = new ReaderList();
    Scanner sc = new Scanner(System.in);
    Validate validate = new Validate();

    public int menuWithObject() {
        System.out.println("=========MENU==========");
        System.out.println("1.Book");
        System.out.println("2.Reader.");
        System.out.println("3.Lending.");
        System.out.println("Enter the other number to exit...");
        System.out.println("Please choose object you want to work with:");
        int choice = validate.getInt("", "Enter again", 0);
        System.out.println("=======================");
        return choice;
    }

    public void BookMethod() {
        System.out.println("1.    Load data from file\n"
                + "2.   Input & add to the end\n"
                + "3.   Display data\n"
                + "4.   Save book list to file\n"
                + "5.   Search by bcode\n"
                + "6.   Delete by bcode\n"
                + "7.   Sort by bcode\n"
                + "8.   Input & add to beginning\n"
                + "9.   Add after position  k\n"
                + "10.  Delete position k");
        while (true) {
            System.out.println("Please choose the method:");
            int choice = validate.getInt("", "Must be > 0", 0);
            System.out.println("=======================");
            switch (choice) {
                case 1:
                    System.out.print("Enter file name: ");
                    //co the nang cap bat nguoi dung nhap file duoi .txt
                    String fileName = sc.nextLine();
                    bookList.loadFromFile(fileName);
                    System.out.println("Read file successfully!");
                    break;
                case 2:
                    bookList.inputAddlast();
                    break;
                case 3:
                    bookList.Display();
                    break;
                case 4:
                    bookList.saveToFile();
                    break;
                case 5:
                    System.out.println("Enter the code want to search:");
                    String bcode = validate.getString("^[A-Za-z][0-9]+$", "");
                    if (bookList.search(bcode) == null) {;
                        System.out.println("Not Found!");
                    } else {
                        System.out.println("Found!");
                    }
                    break;

                case 6:
                    System.out.println("Enter the code want to delete:");
                    bcode = validate.getString("^[A-Za-z][0-9]+$", "");
                    bookList.dele(bcode);
                    break;
                case 7:
                    try {
                        bookList.sortByBcode();
                        System.out.println("Sort Successfully!");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 8:
                    bookList.inputAddFirst();
                    break;
                case 9:
                    int index = validate.getInt("Enter the index you want to insert after:", "Must be greater than 0", 0);
                    bookList.inputAddBefore(index);
                    break;
                case 10:
                    int indexDelete = validate.getInt("Enter the index you want to delete:", "Must be greater than 0", 0);
                    bookList.removePos(indexDelete);
                    break;
                default:
                    return;
            }
        }

    }

    public void ReaderMethod() {
        System.out.println("1.    Load data from file\n"
                + "2.   Input & add to the end\n"
                + "3.   Display data\n"
                + "4.   Save reader list to file\n"
                + "5.   Search by rcode\n"
                + "6.   Delete By rcode");
        while (true) {
            System.out.println("Please choose the method:");
            int choice = validate.getInt("", "Must be > 0", 0);
            System.out.println("=======================");
            switch (choice) {
                case 1:
                    System.out.print("Enter file name: ");
                    //co the nang cap bat nguoi dung nhap file duoi .txt
                    String fileName = sc.nextLine();
                    readerList.loadFromFile(fileName);
                    System.out.println("Read file successfully!");
                    break;
                case 2:
                    readerList.inputAddlast();
                    break;
                case 3:
                    readerList.Display();
                    break;
                case 4:
                    readerList.saveToFile();
                    break;
                case 5:
                    System.out.println("Enter the code want to search:");
                    String rcode = validate.getString("^[A-Za-z][0-9]+$", "");
                    if (readerList.search(rcode) == null) {;
                        System.out.println("Not Found!");
                    } else {
                        System.out.println("Found!");
                    }
                    break;

                case 6:
                    System.out.println("Enter the code want to delete:");
                    rcode = validate.getString("^[A-Za-z][0-9]+$", "");
                    readerList.dele(rcode);
                    break;
                default:
                    return;
            }
        }
    }

    public void LendingMethod() {
        System.out.println("1.    Input data\n"
                + "2.   Display data\n"
                + "3.   Sort by bcode + rcode.");
        while (true) {
            System.out.println("Please choose the method:");
            int choice = validate.getInt("", "Must be > 0", 0);
            System.out.println("=======================");
            switch (choice) {
                case 1:
                    lendngList.inputAddlast();
                    break;
                case 2:
                    lendngList.Display();
                    break;
                case 3:
                    lendngList.sortByBcodeAndRCode();
                    break;
                default:
                    return;
            }
        }
    }

}
