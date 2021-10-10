package com.paulbaogjava.files.filereader;

import com.paulbaogjava.files.FileConstants;

public class FileReaderApp {
    public static void main(String[] args) {
     /*FileReader is a Java convenience class for reading text files.
     FileReader extends InputStreamReader and creates the FileInputStream.
      */

//        FileReaderUtils.readAText(FileConstants.BUGS4);

        /* FileReader's performance can be improved with BufferedReader  */
//        FileReaderUtils.readATextWithBufferedReader(FileConstants.BUGS4);


        WordCount wordCount = new WordCount();

        wordCount.readAFile(FileConstants.BUGS4);

        wordCount.getWords()
                .forEach((k,v)->{
                    System.out.printf("%s -> %d%n", k, v);
                });




    }
}
