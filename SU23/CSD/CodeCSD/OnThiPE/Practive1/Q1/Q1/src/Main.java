// ======= DO NOT EDIT ANY THING IN THIS FILE ============
import java.io.*;
import java.util.*;
class Main {
   public static void main(String args[]) throws Exception {
    MyList t = new MyList();
    int choice;
    Scanner sca = new Scanner(System.in);
    System.out.println();
    System.out.println(" 1. Test f1 (2.5 mark)");
    System.out.println(" 2. Test f2 (2.5 mark)");
    System.out.println(" 3. Test f3 (2.5 mark)");
    System.out.println(" 4. Test f4 (2.5 mark)");
    System.out.println(" 0. Exit");
    System.out.print("    Your selection (0 -> 4): ");
    choice = sca.nextInt();
    sca.nextLine();
    if(choice==0) return;
    switch(choice) {
       case 1: t.f1();
               System.out.println("Your output:");
               Lib.viewFile("f1.txt");
               break;
       case 2: t.f2();
               System.out.println("Your output:");
               Lib.viewFile("f2.txt");
               break;
       case 3: t.f3();
               System.out.println("Your output:");
               Lib.viewFile("f3.txt");
               break;
       case 4: t.f4();
               System.out.println("Your output:");
               Lib.viewFile("f4.txt");
               break;
       default: t.f1();
               System.out.println("Your output:");
               Lib.viewFile("f1.txt");
               t.f2();
               System.out.println("Your output:");
               Lib.viewFile("f2.txt");
               t.f3();
               System.out.println("Your output:");
               Lib.viewFile("f3.txt");
               t.f4();
               System.out.println("Your output:");
               Lib.viewFile("f4.txt");
      }
     System.out.println();
   }      
 }
