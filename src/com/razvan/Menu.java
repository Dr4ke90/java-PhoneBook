package com.razvan;

public class Menu {

    private final int MIN = 1;
    private final int MAX = 3;


    public Byte showMenu() {
        System.out.println("1 - Type 1 for adding new contact");
        System.out.println("2 - Type 2 for searching a contact");
        System.out.println("3 - Type 3 if you wana remove a contact");
        while (true) {
            String input = Console.readMenuValue("Input : ");
            byte value = Byte.parseByte(input);
            if (value >= MIN && value <= MAX)
                return value;
            System.out.println("Please choose a number between 1 and 3");
        }
    }

}
