package com.paulbaogjava.configparer;

import com.paulbaogjava.configparer.service.ConfigParserFileUtil;
import com.paulbaogjava.configparer.service.impl.ConfigParserFileUtilService;

import java.util.Scanner;

public class Main {

    private static   ConfigParser configParser;
    private final static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {

//        ConfigParserFileUtilService parserService = new ConfigParserFileUtil();

//        parserService.readParserFile(ParserFileConstants.CONFIG_TXT);




        if(args.length == 0){

            configParser = new ConfigParser(ParserFileConstants.DEVELOPMENT_FILE_PATH);

            configParser.printConfiguration();
        }else if(args[0].equals(ParserFileConstants.PRODUCTION)) {
            configParser = new ConfigParser(ParserFileConstants.PRODUCTION_FILE_PATH);
            configParser.printConfiguration();
        }else if(args[0].equals(ParserFileConstants.STAGING)){
            configParser = new ConfigParser(ParserFileConstants.STAGING_FILE_PATH);
            configParser.printConfiguration();
        }



    }


}
