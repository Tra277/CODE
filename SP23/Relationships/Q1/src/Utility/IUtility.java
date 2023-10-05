package Utility;

import java.util.Scanner;

public interface IUtility {
        int getInt(Scanner sc,String msg,int min, int max);
        String getString(Scanner sc, String msg, String pattern);
}
