package org.example;

import java.util.Map;

public class Encrypt {
    public static String encrypt(String plaintext) {
        StringBuilder ciphertext = new StringBuilder();
        Map<String, int[]> positionMap = Cifrado.getPositionMap();
        String[][] alphabetMatrix = Cifrado.ALPHABETS_AND_NUMBERS;

        for (char c : plaintext.toUpperCase().toCharArray()) {
            String charStr = String.valueOf(c);
            if (positionMap.containsKey(charStr)) {
                int[] pos = positionMap.get(charStr);
                int newRow = (pos[0] + 1) % alphabetMatrix.length; // Move down one row
                char encryptedChar = alphabetMatrix[newRow][pos[1]].charAt(0);
                ciphertext.append(encryptedChar);
            } else {
                // If character is not in the matrix, keep it unchanged
                ciphertext.append(c);
            }
        }
        return ciphertext.toString();
    }
}
