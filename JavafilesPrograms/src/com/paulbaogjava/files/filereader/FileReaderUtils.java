package com.paulbaogjava.files.filereader;


import com.paulbaogjava.files.utils.ExceptionUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public final  class  FileReaderUtils {

    public static void readAText(String filePath){
        ExceptionUtils.callFileNotFoundException(filePath);
        try(FileReader fileReader = new FileReader(filePath, StandardCharsets.UTF_8)) {

        final  char[] buffer = new char[1024];// file reader does not av available();

            int i;

            while((i = fileReader.read(buffer)) != -1){

                System.out.println(buffer);

            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readATextWithBufferedReader(String filePath){

        ExceptionUtils.callFileNotFoundException(filePath);

        try(BufferedReader bf = new BufferedReader(new FileReader(filePath, StandardCharsets.UTF_8))) {

            String line;

            while((line = bf.readLine()) != null){ //The readLine reads a line of text

                if(line.isEmpty()) continue;
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
