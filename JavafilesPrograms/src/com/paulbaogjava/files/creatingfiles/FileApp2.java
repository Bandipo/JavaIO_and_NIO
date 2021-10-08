package com.paulbaogjava.files.creatingfiles;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileApp2 {
   private static final String  FILE_PATH = "src/resources/";
    public static void main(String[] args) {
        File file = new File(FILE_PATH+"newfile.txt");// java io

        Path path1 = Paths.get(FILE_PATH + "newfile.txt2"); // java nio

        //method1: java io way
        FileCreatorUtility.createAFile(file);

        //method2: java nio way

        FileCreatorUtility.createAFile(path1);

        FileCreatorUtility.createAFile(Paths.get(FILE_PATH+"thermopylae.txt"));





    }
}
