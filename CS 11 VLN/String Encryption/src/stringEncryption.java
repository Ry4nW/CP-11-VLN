import java.util.Scanner;

public class stringEncryption {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to String Encryption.\nSample: Hello -> oHellay\nEnter a string to be encrypted:");

        String str = input.nextLine();
        int lastIndex = str.length() - 1;
        char lastChar = str.charAt(lastIndex);
        String newStr = str.substring(0, lastIndex);
        String encryptedStr = lastChar + newStr + "ay";

        System.out.println("Encrypted String: " + encryptedStr + "\n\n*************************\n");

        System.out.println("Enter a string to be translated:");

        String eStr = input.nextLine();
        char firstChar = eStr.charAt(0);
        String translatedStr = newStr + firstChar;

        System.out.println("Translated String: " + translatedStr);

    }
}
