package com.paulbaogjava.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFileAttributes;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

public class JavaFileApp {
    private static final Logger LOGGER = Logger.getLogger(JavaFileApp.class.getName());
    public static void main(String[] args) {

        Set<PosixFilePermission> perms = new HashSet<>();
        perms.add(PosixFilePermission.OWNER_WRITE);
        perms.add(PosixFilePermission.OWNER_READ);
        perms.add(PosixFilePermission.GROUP_WRITE);
        perms.add(PosixFilePermission.GROUP_READ);
        perms.add(PosixFilePermission.OTHERS_READ);

        FileAttribute<Set<PosixFilePermission>> fileAttribute = PosixFilePermissions.asFileAttribute(perms);

        Path path1 = Paths.get(FileConstants.FILE_PATH+"bugs1.txt");
        Path path2 = Paths.get(FileConstants.FILE_PATH+"bugs.txt");

       //Create a file
        FilesUtils.createAFile(path1);


      //Check a file size
        long fileSize = FilesUtils.getFileSize(path1);
        long fileSize1 = FilesUtils.getFileSize(path2);

        LOGGER.info("file : " + fileSize );
        LOGGER.info("file 1: "+fileSize1);



    }
}
