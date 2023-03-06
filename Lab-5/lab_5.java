import java.util.*;

public class lab_5 {
    static Scanner sc = new Scanner(System.in);
    static char plain[] = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
    static char cipher[] = {'X','Y','Z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W'};

    public static void main(String[] args) {
        String text;
        char choice;
        char ch;
        do{
            System.out.println("*********************************************************************************************");
            System.out.print("Press: \n'E' for Encryption. \n'D' for Decryption.\nAnything else for Exit.\nChoose your programm: ");
            choice = sc.nextLine().toUpperCase().charAt(0);
            if (choice == 'E') {
                System.out.print("Enter the message you want to encrypt: ");
                text = sc.nextLine();
                String encryptedText = encryption(text);
                System.out.println("Encrypted message: " + encryptedText);
            } else if (choice == 'D') {
                System.out.print("Enter the message you want to decrypt: ");
                text = sc.nextLine();
                String decryptedMessage = decryption(text);
                System.out.println("Decrypted message: " + decryptedMessage);
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
            System.out.println("Press 'y' or 'Y' to continue..!");
            ch = sc.nextLine().charAt(0);
        }while (ch == 'y' || ch == 'Y');
        System.out.println("Programm Ends.");
    }

    static String encryption(String text) {
        StringBuilder encryptedText = new StringBuilder();
        for (char letter : text.toCharArray()) {
            char encryptedLetter = replaceLetter(letter, plain, cipher);
            encryptedText.append(encryptedLetter);
        }
        return encryptedText.toString();
    }

    static String decryption(String text) {
        StringBuilder decryptedMessage = new StringBuilder();

        for (char letter : text.toCharArray()) {
            char decryptedLetter = replaceLetter(letter, cipher, plain);
            decryptedMessage.append(decryptedLetter);
        }
        return decryptedMessage.toString();
    }

    static char replaceLetter(char letter, char[] fromTable, char[] toTable) {
        boolean isLowerCase = Character.isLowerCase(letter);
        letter = Character.toUpperCase(letter);

        for (int i = 0; i < fromTable.length; i++) {
            if (letter == fromTable[i]) {
                char replacedLetter = toTable[i];

                if (isLowerCase) {
                    replacedLetter = Character.toLowerCase(replacedLetter);
                }
                return replacedLetter;
            }
        }
        return letter;
    }
}
