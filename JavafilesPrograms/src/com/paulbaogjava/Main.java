package com.paulbaogjava;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// write your code here

        String testString = "I love the fact! that I am here, yes!";

        String result = testString.replaceAll("[!?|.,]", "");

        System.out.println(result);

        String[] splitResult = result.split(" ");



        System.out.println(Arrays.toString(splitResult));

        int i = 0;
        for(String s : splitResult){

            if(i%3 == 0){
                System.out.println();
            }

            System.out.print(s.trim()+ " ");

            i++;

        }





    }
}
