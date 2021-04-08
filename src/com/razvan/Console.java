package com.razvan;

import java.util.Scanner;

public class Console {

    private static final Scanner scanner = new Scanner(System.in);


    public static String readLine(String text) {
        System.out.print(text);
        return scanner.nextLine();
    }


    public static String readNumber(String text) {
        String value;
        while (true) {
            System.out.print(text);
            value = scanner.nextLine();
            if (!value.matches("[a-zA-Z]+") && value.length() == 10)
                return value;
            System.out.println("Please enter a valid telephone number");
        }
    }


    public static String readMenuValue (String text) {
        String value;
        while (true) {
            System.out.print(text);
            value = scanner.nextLine();
            if (!value.matches("[a-zA-Z]+") && value.length() == 1)
                return value;
            System.out.println("Please choose a number between 1 and 3");
        }
    }


}
