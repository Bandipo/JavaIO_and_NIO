package com.paulbaogjava.files.utils;

import com.paulbaogjava.exceptions.MyFileNotAvailable;

import java.nio.file.Files;
import java.nio.file.Path;

public final class ExceptionUtils {

    public static void callFileNotFoundException(final String filePath){

        if(! Files.exists(Path.of(filePath))) throw new MyFileNotAvailable("File Not found");


    }
}
