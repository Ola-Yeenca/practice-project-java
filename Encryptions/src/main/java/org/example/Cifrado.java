package org.example;

import java.util.HashMap;
import java.util.Map;

public class Cifrado {
    public static final String[][] ALPHABETS_AND_NUMBERS = {
            {"A", "B", "C", "D", "E", "F"},
            {"G", "H", "I", "J", "K", "L"},
            {"M", "N", "O", "P", "Q", "R"},
            {"S", "T", "U", "V", "W", "X"},
            {"Y", "Z", "0", "1", "2", "3"},
            {"4", "5", "6", "7", "8", "9"}
    };

    private static final Map<String, int[]> positionMap = new HashMap<>();

    static {
        for (int i = 0; i < ALPHABETS_AND_NUMBERS.length; i++) {
            for (int j = 0; j < ALPHABETS_AND_NUMBERS[i].length; j++) {
                positionMap.put(ALPHABETS_AND_NUMBERS[i][j], new int[]{i, j});
            }
        }
    }

    public static Map<String, int[]> getPositionMap() {
        return positionMap;
    }
}
