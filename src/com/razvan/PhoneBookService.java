package com.razvan;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class PhoneBookService {


    private final ContactDao cd;
    private final Contact contact;
    private final Menu menu;

    public PhoneBookService(ContactDao cd, Contact contact, Menu menu) {
        this.cd = cd;
        this.contact = contact;
        this.menu = menu;
    }

    public void start() {
        byte input = menu.showMenu();
        if (input == 1)
            addContact();
        else if (input == 2)
            searchContact();
        else if (input == 3)
            deleteContact();

    }


    private void searchContact() {
        while (true) {
            String contactSought = Console.readLine("Contact : ");
            String contactReturned = cd.readFromCsv(contactSought);
            if (contactReturned != null) {
                System.out.println(contactReturned);
                start();
            } else
                System.out.println("This contact doesn't exist");
        }
    }


    private void addContact() {
        while (true) {
            String name = Console.readLine("Name : ");
            contact.setName(name);
            if (exist(name)) {
                System.out.println("This contact already exist");
                continue;
            }

            String nr = Console.readNumber("Number : ");
            contact.setTelephoneNr(nr);
            if (succed()) {
                System.out.println("Contact saved");
                start();
            } else
                System.out.println("Contact cannot be saved");
        }
    }

    private boolean exist(String name) {
        String exist = cd.readFromCsv(name);
        return exist != null;
    }


    private boolean succed() {
        return cd.writeToCsv(contact.getName(), contact.getTelephoneNr());
    }


    private void deleteContact() {
        String toRemove = Console.readLine("Contact to remove : ");
        if (exist(toRemove)) {
            cd.removeFromCsv(toRemove);
            System.out.println("Contact removed");
        } else {
            System.out.println("Contact doesn't exist");
        }
        start();
    }

}
