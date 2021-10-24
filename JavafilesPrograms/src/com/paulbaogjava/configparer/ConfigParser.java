package com.paulbaogjava.configparer;

import com.paulbaogjava.configparer.exception.ParserFileNotFound;
import com.paulbaogjava.configparer.service.ConfigParserFileUtil;
import com.paulbaogjava.configparer.service.impl.ConfigParserFileUtilService;
import com.paulbaogjava.exceptions.ConfigKeyNotFound;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class ConfigParser  {

    private static Map<String, String> configuration = new HashMap<>();
    private final String fileName;
    private final  ConfigParserFileUtilService fileService = new ConfigParserFileUtil();


    public ConfigParser(final String fileName) {
        this.fileName = fileName == null || fileName.isEmpty()? ParserFileConstants.DEVELOPMENT_FILE_PATH : fileName;
        parseFile(this.fileName);
    }


    private void parseFile(final String filePath){
        //first read the file
        //process the file
        readConfigFile(filePath);

    }


    private void readConfigFile(final String filePath){
        if(!Files.exists(Path.of(filePath))) throw new ParserFileNotFound("Parser file not found");

        try(BufferedReader reader = Files.newBufferedReader(Path.of(filePath), StandardCharsets.UTF_8)) {

            String line;
            String key = "";
            while((line = reader.readLine()) != null){
                if(line.isEmpty()){
                    key = "";
                    continue;
                }

                if(line.startsWith("[") && line.endsWith("]")){
                    key = line.substring(line.indexOf("[")+1, line.indexOf("]")) +".";
                }else{
                    processFileLine(line, key);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void processFileLine(String line, String header){

        final String[] split = line.split("=");
        final String configKey = header+split[0];
        final String configValue = split[1];

        if(!configuration.containsKey(configKey)){
            configuration.put(configKey, configValue);
        }else{
            configuration.put(configKey, configValue);
        }






    }

    public String getConfigKey(final String configKey){

       if(!configuration.containsKey(configKey)) throw new ConfigKeyNotFound("Config key not found");

       return configuration.get(configKey);
    }

    public void printConfiguration(){
        configuration.forEach((k,v) ->{
            System.out.printf("%n %s : %s ", k,v);
        });
    }

}
