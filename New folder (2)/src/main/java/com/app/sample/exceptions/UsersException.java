package com.app.sample.exceptions;

@SuppressWarnings("serial")
public class UsersException extends Exception {

    public UsersException(String errorMessage) {
        super(errorMessage);
    }

    public UsersException(String errorMessage, Throwable cause) {
        super(errorMessage, cause);
    }

}