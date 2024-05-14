package org.example;

import java.util.Map;

public class Decrypt {
    public static String decrypt(String ciphertext) {
        StringBuilder plaintext = new StringBuilder();
        Map<String, int[]> positionMap = Cifrado.getPositionMap();
        String[][] alphabetMatrix = Cifrado.ALPHABETS_AND_NUMBERS;

        for (char c : ciphertext.toUpperCase().toCharArray()) {
            String charStr = String.valueOf(c);
            boolean found = false;
            for (int i = 0; i < alphabetMatrix.length; i++) {
                for (int j = 0; j < alphabetMatrix[i].length; j++) {
                    if (alphabetMatrix[i][j].charAt(0) == c) {
                        int newRow = (i - 1 + alphabetMatrix.length) % alphabetMatrix.length; // Move up one row
                        char decryptedChar = alphabetMatrix[newRow][j].charAt(0);
                        plaintext.append(decryptedChar);
                        found = true;
                        break;
                    }
                }
                if (found) {
                    break;
                }
            }
            if (!found) {
                // If character is not in the matrix, keep it unchanged
                plaintext.append(c);
            }
        }
        return plaintext.toString();
    }
}
