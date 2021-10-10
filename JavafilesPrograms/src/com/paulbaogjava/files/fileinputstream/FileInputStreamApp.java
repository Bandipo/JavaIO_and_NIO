package com.paulbaogjava.files.fileinputstream;

import com.paulbaogjava.files.FileConstants;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamApp {

    public static void main(String[] args) {

        try( FileInputStream fileInputStream = new FileInputStream(FileConstants.BUGS4)) {

            System.out.println("available: "+fileInputStream.available());
            int read = fileInputStream.read();
            System.out.println((char) read);


        } catch (IOException e) {
            e.printStackTrace();
        }

        // this method is not an  efficient way of reading files
//        FileInputStreamUtils.readFileByCharacters(FileConstants.BUGS4);



//        FileInputStreamUtils.readFileByChunks(FileConstants.BUGS4);


        FileInputStreamUtils.readFileUsingBufferedReader(FileConstants.BUGS4);

    }
}
