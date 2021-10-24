package com.paulbaogjava.exceptions;

public class ConfigKeyNotFound extends RuntimeException{
    public ConfigKeyNotFound(String message) {
        super(message);
    }
}
