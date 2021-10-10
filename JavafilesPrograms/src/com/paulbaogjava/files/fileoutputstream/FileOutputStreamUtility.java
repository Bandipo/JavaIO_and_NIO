package com.paulbaogjava.files.fileoutputstream;

import com.paulbaogjava.exceptions.MyFileNotAvailable;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public final class FileOutputStreamUtility {

    public static void writeLineOfStringToAFile(final String filePath, final String linesToWrite){

        try(FileOutputStream fos = new FileOutputStream(filePath)){

            fos.write(linesToWrite.getBytes(StandardCharsets.UTF_8));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }



}
