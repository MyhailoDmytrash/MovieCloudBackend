package com.example.application.exceptions;

public class RatingServiceException extends Throwable
{
    public static final String CAN_NOT_SAVE_RATING = "Can't save rating";
    public static final String UNKNOWN_ERROR = "Unknown error";

    public RatingServiceException(String message) {
        super(message);
    }
}
