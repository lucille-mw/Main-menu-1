import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.*;
import java.io.*;


public abstract class UsernameValidation extends JFrame implements ActionListener {
    public static String UsernameValidation(String str) {
            // code goes here
            boolean correctUsername = false;

            if(correctLength(str) && startsWithLetter(str) && lettersNumsUnderscore(str) && noUnderscoreAtEnd(str)){
                correctUsername = true;
                return "true";
            }else{
                correctUsername = false;
                return "false";

            }
        }

        public static boolean correctLength(String str){
            // if statement which would check to see if str is greater then 4 and less then 25 characters
            if(str.length() >= 4 && str.length() <= 25){
                return true;
            }else{
                System.out.print("Username must be between 4 and 25 characters, please try again.");
                return false;
            }
        }


        public static boolean startsWithLetter(String str) {
            char startChar = str.charAt(0);
            if (startChar >= 'a' && startChar <= 'z' || startChar >= 'A' && startChar <= 'Z') {
                return true;
            } else {
                System.out.println("Username must start with a letter please try again!");
                return false;

            }
        }

        public static boolean lettersNumsUnderscore(String str){
            if(str.matches(("[A-Za-z0-9_]+"))){
                return true;
            }else {
                System.out.println("Username must contain letters, numbers and an underscore, please try again.");
                return false;
            }

        }

        public static boolean noUnderscoreAtEnd(String str){
            char endChar = str.charAt(str.length() - 1);

            if (endChar == '_') {
                System.out.print("Username must not end with an underscore, please try again.");
                return false;
            } else {
                return true;

            }
        }






    }