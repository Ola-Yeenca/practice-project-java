package org.example;

import java.util.Scanner;

public class ReadInput {
    public static String read() {
        System.out.println("Welcome to Calculator!");

        System.out.println("***********************");
        System.out.println("***********************");
        System.out.println("***********************");
        System.out.println("***********************");
        System.out.println("***********************");
        System.out.println("***********************");
        System.out.println("***********************");




        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter the values (example 5+5): ");

        String inputLine = sc.nextLine();

        sc.close();
        return inputLine;
    }
}
