package com.paulbaogjava.files.creatingfiles;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Logger;

public final class FileCreatorUtility {

        private static  final Logger LOGGER = Logger.getLogger(FileCreatorUtility.class.getName());

    protected static void createAFile(final File file){
        boolean isFileCreated = false;
        try {
            isFileCreated = file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        LOGGER.info(isFileCreated ? "File is created": "File already exist");
    }

    protected static void createAFile(final Path path){
        if(!Files.exists(path)){
            try {
                Files.createFile(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        LOGGER.info("File created in the NIO way");
    }
}
