package com.paulbaogjava.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Logger;


public class FilesUtils {

    private final static Logger logger = Logger.getLogger(FilesUtils.class.getName());


    public static  void createAFile (final Path path){

        if(Files.exists(path)){
            logger.info("File already exist");

        }else {
            try {
                Files.createFile(path);
                 logger.info("file created");
            } catch (IOException e) {
                logger.warning(e.getMessage());
            }
        }






    }

    public static long  getFileSize(final Path path){
        long  returnType = 0;
        try {
         returnType = Files.size(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return returnType;
    }
}
