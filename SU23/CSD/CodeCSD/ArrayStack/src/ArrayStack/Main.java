package ArrayStack;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int choice; int  x, k;
         Scanner s = new Scanner(System.in);
         ArrayStack d = new ArrayStack();
         Integer X; 
         while(true)
            { System.out.println();
              System.out.println("1. Push");
              System.out.println("2. Top");
              System.out.println("3. Pop");
              System.out.println("4. Display all");
              System.out.println("0. Exit");
              System.out.print("    Your selection (0 -> 4):  ");
              choice = s.nextInt();
              if(choice==0) break;
              switch(choice)
                  { case 1: System.out.print("Enter the value to be pushed: ");
                                  x = s.nextInt();
                                  X = new Integer(x);
                                  d.push(X);
                                  break;
                    case 2: System.out.println("The element at the top is  " + d.top());
                                  break;
                    case 3: System.out.println("The element poped  is  " + d.pop());
                                  break;
                    case 4: d.displayAll();
                                  break;
                  }
            }

    }
    
}
