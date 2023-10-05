package mainManagement;

public class Main {
    public static void main(String[] args) {
        Validate validate = new Validate();        
        Manager manager = new Manager();
        while (true) {            
            int choice = manager.menuWithObject();
            switch(choice){
                case 1:
                    manager.BookMethod();
                    break;
                case 2: 
                    manager.ReaderMethod();
                    break;
                case 3:
                    manager.LendingMethod();
                    break;
                default:
                    return;
            }
        }
    }

}
