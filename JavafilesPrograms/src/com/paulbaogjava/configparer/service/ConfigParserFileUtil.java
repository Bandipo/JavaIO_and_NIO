package com.paulbaogjava.configparer.service;


import com.paulbaogjava.configparer.exception.ParserFileNotFound;
import com.paulbaogjava.configparer.service.impl.ConfigParserFileUtilService;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class ConfigParserFileUtil implements ConfigParserFileUtilService {




    @Override
    public void readParserFile(String filePath) {

        if(!Files.exists(Path.of(filePath))) throw new ParserFileNotFound("Parser file not found");

        try(BufferedReader reader = Files.newBufferedReader(Path.of(filePath),StandardCharsets.UTF_8)) {

            String line;
            while((line = reader.readLine()) != null){
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
