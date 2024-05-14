package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hello and welcome to Encoding and Decoding in Java!");

        System.out.println("Input the number of the key (0-6): ");
        int key = scanner.nextInt();
        if (key < 0 || key > 6) {
            System.out.println("Sorry, key value must be between 0 and 6.");
            return;
        }

        scanner.nextLine(); // Consume newline

        System.out.println("Please enter the sentence you want to encode: ");
        String plainText = scanner.nextLine();

        String cipherText = Encrypt.encrypt(plainText);
        System.out.println("The cipher text is: " + cipherText);

        String decryptedText = Decrypt.decrypt(cipherText);
        System.out.println("The decrypted text is: " + decryptedText);

        scanner.close();
    }
}
