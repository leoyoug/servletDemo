package com.touch.exception;

public class UserNotlegitException extends Exception{
    public UserNotlegitException() {
        super();
    }

    public UserNotlegitException(String message) {
        super(message);
    }

    public UserNotlegitException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserNotlegitException(Throwable cause) {
        super(cause);
    }
}
