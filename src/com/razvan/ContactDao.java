package com.razvan;

import java.io.*;
import java.nio.file.Files;
import java.util.Scanner;

public class ContactDao {

    private CsvFiles csvFiles;
    private FileWriter fileWriter;
    private PrintWriter printWriter;
    private Scanner scanner;


    public boolean writeToCsv(String name, String telephone) {
        csvFiles = new CsvFiles();
        try {
            fileWriter = new FileWriter(csvFiles.getToRead(), true);
            printWriter = new PrintWriter(fileWriter);
            printWriter.println(name + " , " + telephone);
            printWriter.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }


    public String readFromCsv(String toFind) {
        String name;
        String telephone;
        csvFiles = new CsvFiles();
        try {
            scanner = new Scanner(csvFiles.getToRead());
            scanner.useDelimiter("[,\n]");
            while (scanner.hasNext()) {
                name = scanner.next().trim();
                telephone = scanner.next().trim();
                if (name.equals(toFind)) {
                    return name + " => " + telephone;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public void removeFromCsv(String toRemove) {
        String name;
        String telephone;
        csvFiles = new CsvFiles();
        try {
            fileWriter = new FileWriter(csvFiles.getToWrite(), true);
            printWriter = new PrintWriter(fileWriter);
            scanner = new Scanner(csvFiles.getToRead());
            scanner.useDelimiter("[,\n]");
            while (scanner.hasNext()) {
                name = scanner.next().trim();
                telephone = scanner.next().trim();
                if (!name.equals(toRemove)) {
                    printWriter.println(name + " , " + telephone);
                }
            }
            scanner.close();
            printWriter.flush();
            printWriter.close();
            System.gc();

            Files.delete(csvFiles.getToRead().toPath());
            csvFiles.getToWrite().renameTo(csvFiles.getToRead());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
