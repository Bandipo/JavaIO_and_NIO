package com.paulbaogjava.files.filereader;

import com.paulbaogjava.files.utils.ExceptionUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

public class WordCount {


    private  final HashMap<String, Integer> words =  new HashMap<>();

    public  void readAFile(final String fileName){

        ExceptionUtils.callFileNotFoundException(fileName);

        try(BufferedReader bf = new BufferedReader(new FileReader(fileName, StandardCharsets.UTF_8))) {

            String line ;

            while((line = bf.readLine()) != null){

                processString(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private  void processString(String line) {

        String s = line.replaceAll("[!?|.,]", "");

        String[] splitString = s.split(" ");

        wordCount(splitString);



    }

    private void wordCount(String[] splitString) {
          if(splitString == null) throw new NullPointerException("array is null");
        for(String element : splitString){

           final String word = element.trim();

            if(this.words.containsKey(word)){
                words.put(word, words.get(word) + 1);
            }else{
                words.put(word, 1);
            }

        }
    }

    public HashMap<String, Integer> getWords() {
        return words;
    }
}
