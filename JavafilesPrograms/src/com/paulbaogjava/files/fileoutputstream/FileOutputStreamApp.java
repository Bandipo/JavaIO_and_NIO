package com.paulbaogjava.files.fileoutputstream;

public class FileOutputStreamApp {

    public static void main(String[] args) {

        String fileName = "src/resources/filetowrite.txt";

        FileOutputStreamUtility.writeLineOfStringToAFile(fileName, "Hello every body");

    }
}
