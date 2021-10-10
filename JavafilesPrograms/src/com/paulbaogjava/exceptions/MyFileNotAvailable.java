package com.paulbaogjava.exceptions;

public class MyFileNotAvailable extends RuntimeException{

    public MyFileNotAvailable(){
        super();
    }

    public MyFileNotAvailable(String message){
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
