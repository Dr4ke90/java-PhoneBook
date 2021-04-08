package com.razvan;

public class Main {

    public static void main(String[] args) {


        ContactDao cd = new ContactDao();
        Contact contact = new Contact();
        Menu menu = new Menu();

        PhoneBookService pbs = new PhoneBookService(cd, contact, menu);
        pbs.start();

    }
}