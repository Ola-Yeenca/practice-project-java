package org.example;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        final String inputExp = ReadInput.read();

        Queue<String> operations;
        Queue<String> numbers;

        String[] numbersArr = inputExp.split("[-+*/]");
        String[] operatorsArr = inputExp.split("[0-9]+");


        numbers = new LinkedList<String>(Arrays.asList(numbersArr));
        operations = new LinkedList<String>(Arrays.asList(operatorsArr));

        Double res = Double.parseDouble(Objects.requireNonNull(numbers.poll()));


        while (!numbers.isEmpty()) {
            String opr = operations.poll();

            OperateSigns operate = null;

            switch (opr) {
                case "+":
                    operate = new Addition();
                    break;

                case "-":
                    operate = new Subtraction();
                    break;

                case "*":
                    operate = new Multiplication();
                    break;

                case "/":
                    operate = new Division();
                    break;

                case null:
                    break;
                default:
                    continue;
            }
            Double num = Double.parseDouble(Objects.requireNonNull(numbers.poll()));

            assert operate != null;
            res = operate.getResult(res, num);
        }

        System.out.println(res);

    }
}