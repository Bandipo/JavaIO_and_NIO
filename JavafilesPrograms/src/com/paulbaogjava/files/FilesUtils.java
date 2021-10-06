package com.paulbaogjava.files;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermission;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.logging.Logger;

//the class is made final since it is just a helperClass. Therefore, it can't be extended
public final class FilesUtils {

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
    public static  void createAFile (final Path path, final FileAttribute<Set<PosixFilePermission>> fileAttribute){

        if(Files.exists(path)){
            logger.info("File already exist");

        }else {
            try {
                Files.createFile(path, fileAttribute);
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

    public static void deleteAFile(final Path path){
        boolean isFileDeleted = false;
        try {
             isFileDeleted = Files.deleteIfExists(path);
        } catch (IOException e) {
            e.printStackTrace();
        }


        logger.info( isFileDeleted ? " File is deleted": " file is not deleted");

    }

    public static void moveFile(final Path sourcePath, final Path destinationPath){

        if(Files.exists(sourcePath) &&  !Files.exists(destinationPath)){

            try {
                Files.move(sourcePath, destinationPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        logger.info("File is moved from "
                + sourcePath.toString()+" to "
                + destinationPath.toString());
    }

    public static void readFileUsingReadAllLine(final Path path){

        List<String> content = null;

       if(Files.exists(path)){
           try {
              content = Files.readAllLines(path, StandardCharsets.UTF_8);

           } catch (IOException e) {
               logger.warning(e.getMessage());
           }
       }

        if (content != null) {
            content.forEach(System.out::println);
        }

    }

    public static Optional< List<String>> readFileUsingReadAllLines(final Path path){

        List<String> content = null;

        if(Files.exists(path)){
            try {
                content = Files.readAllLines(path);

            } catch (IOException e) {
                logger.warning(e.getMessage());
            }
        }



        return Optional.ofNullable(content);
    }

    public static void writeToFile(List<String> contentToWrite, Path pathToWrite){

        if(contentToWrite != null){
            try {
                Files.write(pathToWrite, contentToWrite, StandardCharsets.UTF_8, StandardOpenOption.CREATE);
            } catch (IOException e) {
                logger.warning(e.getMessage());
            }
        }

        logger.info("File successfully written");
    }
}
