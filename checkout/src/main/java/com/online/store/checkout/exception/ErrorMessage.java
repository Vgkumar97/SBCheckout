package com.online.store.checkout.exception;

/*
 * Class for Error Message.
 */
public class ErrorMessage {
    private String message;

    private String error;

    public ErrorMessage(String message, String error) {
        this.message = message;
        this.error = error;
    }

    public String getMessage() {
        return message;
    }


    public String getError() {
        return error;
    }
}