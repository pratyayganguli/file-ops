package com.project.fileops.common.exceptions;

public class FileReadExceptions extends RuntimeException{
    public FileReadExceptions(String message) {
        super(message);
    }

    public FileReadExceptions(String message, Throwable cause) {
        super(message, cause);
    }
}
