package com.paulbaogjava.files.inputstreamexample;

public class JavaInputStreamExample {

    public static void main(String[] args) {


        //Reading a file
      String fileName = "src/resources/thermopylae.txt";
      InputStreamExampleUtility.readAFile(fileName);

      //Reading an image
//       String imageFile = "src/resources/ball.png";
//      InputStreamExampleUtility.readAnImage(imageFile);

      //Reading a Url

        String website = "https://zetcode.com/java/inputstream/";



        InputStreamExampleUtility.readAUrl(website);



    }
}
