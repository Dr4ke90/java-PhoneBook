package com.razvan;

import java.io.File;

public class CsvFiles {


    private final File toRead = new File("contacts.csv");
    private final File toWrite = new File("temp.csv");

    public File getToRead() {
        return toRead;
    }

    public File getToWrite() {
        return toWrite;
    }
}
