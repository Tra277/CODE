import java.util.InputMismatchException;
import java.util.Locale;

import java.util.Scanner;

public class Q2 {
  public static void main(String[] args) {
      Locale.setDefault(new Locale("en", "US"));
    Scanner sc = new Scanner(System.in);
    
    double n1 = 0;
    try {
      System.out.print("Enter number #1: ");
      n1 = sc.nextDouble();
    } catch (InputMismatchException e) {
      System.out.println("Invalid input. Please enter a valid number.");
      return;
    }
    double n2 = 0;
    try {
      System.out.print("Enter number #2: ");
      n2 = sc.nextDouble();
    } catch (InputMismatchException e) {
      System.out.println("Invalid input. Please enter a valid number.");
      return;
    }
    System.out.print("Enter operator (+ - * /): ");
    char op = sc.next().charAt(0);
    double result = 0;

    switch (op) {
      case '+':
        result = n1 + n2;
        break;
      case '-':
        result = n1 - n2;
        break;
      case '*':
        result = n1 * n2;
        break;
      case '/':
        result = n1 / n2;
        break;
      default:
        System.out.println("Invalid operator");
        return;
    }
    System.out.format("The result of %.1f %s %.1f = %.1f", n1, op, n2, result);
  }
}
