package com.paulbaogjava.files.inputstreamexample;

public class JavaInputStreamExample {

    public static void main(String[] args) {

      String fileName = "src/resources/thermopylae.txt";

      InputStreamExampleUtility.readAFile(fileName);
      final String imageFile = "src/resources/ball.png";
      InputStreamExampleUtility.readAnImage(imageFile);

    }
}
