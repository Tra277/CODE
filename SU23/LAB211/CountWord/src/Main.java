
import java.util.LinkedHashMap;
import java.util.Scanner;

/**
 * This program counts the occurrences of each character and word in a given
 * input string.
 */
public class Main {

    /**
     * The main method reads an input string from the user and counts the
     * occurrences of each character and word in the input string.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your content:");
        String s = sc.nextLine().trim().toLowerCase();

        // Count characters
        LinkedHashMap<Character, Integer> charCount = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isSpaceChar(s.charAt(i))) {
                if (!charCount.containsKey(s.charAt(i))) {
                    charCount.put(s.charAt(i), 1);
                } else {
                    charCount.put(s.charAt(i), charCount.get(s.charAt(i)) + 1);
                }
            }

        }
        // Print character count
        System.out.print("{");
        for (char i : charCount.keySet()) {
            System.out.print(i + " = " + charCount.get(i) + ", ");
        }
        System.out.println("}");

        // Count words
        LinkedHashMap<String, Integer> wordCount = new LinkedHashMap<>();
        String[] stringArray;
        stringArray = s.split("[ ]");
        for (String string : stringArray) {
            if (checkWord(string)==true) {
                if (!wordCount.containsKey(string)) {
                    wordCount.put(string, 1);
                } else {
                    wordCount.put(string, wordCount.get(string) + 1);
                }
            }

        }

        //use loop to go though a hash map
        System.out.print("{");
        for (String i : wordCount.keySet()) {
            System.out.print(i + " = " + wordCount.get(i) + ", ");
        }
        System.out.println("}");
    }

    static boolean checkWord(String word) {
        boolean check=false;
        for (int i = 0; i < word.length(); i++) {
            if (Character.isLetter(word.charAt(i)) || Character.isDigit(word.charAt(i))) {
                check = true;
            }
        }

        return check;
    }
}
