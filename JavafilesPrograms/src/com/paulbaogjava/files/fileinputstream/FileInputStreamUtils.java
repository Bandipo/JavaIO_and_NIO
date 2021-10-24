package com.paulbaogjava.files.fileinputstream;

import com.paulbaogjava.exceptions.MyFileNotAvailable;


import java.io.*;


import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import java.util.Collections;
import java.util.stream.Collectors;

public final  class FileInputStreamUtils {

    public static void readFileByCharacters(final String fileName){

        throwFileNotFoundException(fileName);

        try(FileInputStream fileInputStream = new FileInputStream(fileName)){

            int i;

            while((i = fileInputStream.read()) != -1){

                System.out.print( (char) i );
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void readFileByChunks(final String fileName){
        throwFileNotFoundException(fileName);

        try(FileInputStream fileInputStream = new FileInputStream(fileName)) {

            final byte[] buffer = new byte[fileInputStream.available()]; //or new byte[fileInputStream.available()]

            int i;
            while((i = fileInputStream.read(buffer)) != -1){

               String valueToPrint = new String(buffer, StandardCharsets.UTF_8);

                System.out.println(valueToPrint);

            }



        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void readFileUsingBufferedReader(final String fileName){
        throwFileNotFoundException(fileName);



        try(final FileInputStream fis = new FileInputStream(fileName);
            final BufferedReader bf = new BufferedReader(new InputStreamReader(fis))){


            bf.lines().forEach(System.out::println);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void throwFileNotFoundException(final String fileName){

        if(!Files.exists(Path.of(fileName))){
            throw new MyFileNotAvailable("File not found");
        }
    }
}
