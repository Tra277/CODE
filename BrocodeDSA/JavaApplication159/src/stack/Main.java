package stack;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Stack<String> myStack = new Stack<String>();
        
        myStack.push("MineCraft");
        myStack.push("CSGO");
        myStack.push("Valorant");
        myStack.push("Dumb way to dies");
        myStack.pop();
        myStack.pop();
        System.out.println(myStack);

    }

}
