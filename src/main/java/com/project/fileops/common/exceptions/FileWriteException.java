package com.project.fileops.common.exceptions;

/**
 * created on: 08 15 2023
 * 11:11 am
 */

public class FileWriteException extends RuntimeException{
    public FileWriteException(String message) {
        super(message);
    }

    public FileWriteException(String message, Throwable cause) {
        super(message, cause);
    }
}
