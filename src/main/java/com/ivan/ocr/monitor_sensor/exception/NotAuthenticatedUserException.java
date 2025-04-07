package com.ivan.ocr.monitor_sensor.exception;

public class NotAuthenticatedUserException extends RuntimeException {
    public NotAuthenticatedUserException(String message) {
        super(message);
    }
}
