package com.paulbaogjava.files.inputstreamexample;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public final class InputStreamExampleUtility {

    private final static Logger LOGGER = Logger.getLogger(InputStreamExampleUtility.class.getName());

    static void readAFile(final String filePathInString){


        try(InputStream fis = new FileInputStream(filePathInString);
              BufferedReader br = new BufferedReader(new InputStreamReader(fis, StandardCharsets.UTF_8))){

            List<String> contents = br.lines().collect(Collectors.toList());
            System.out.println(contents);
               br.lines().forEach(System.out::println);






        } catch ( IOException e) {
           LOGGER.warning(e.getMessage());
        }
    }

    static void readAnImage(final String imagePath){


         try(final InputStream inputStream = new FileInputStream(imagePath)){

             int available = inputStream.available(); //returns number of bytes that can be read
             byte[] buffer = new byte[available];

             inputStream.read(buffer); // reads the bytes into the buffer

             int i = 0;

             for(byte b : buffer){
                 if( i%20 == 0){
                     System.out.println();
                 }

                 System.out.printf("%02x", b);

                 i++;
             }

         } catch (IOException e) {
             e.printStackTrace();
         }



    }

    static void readAUrl(final String website){

        URL url = null;
        try {
            url = new URL(website);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        if (url != null) {
            try( InputStream inputStream = url.openStream();
                  BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {

                br.lines().forEach(System.out::println);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
