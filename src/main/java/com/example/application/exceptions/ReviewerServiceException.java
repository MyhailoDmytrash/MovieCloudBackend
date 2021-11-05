package com.example.application.exceptions;

public class ReviewerServiceException extends Throwable
{
    public static final String CAN_NOT_BE_CREATED = "Reviewer can't be created";
    public static final String REVIEWER_NOT_FOUND = "Reviewer not found";
    public static final String UNKNOWN_ERROR = "Unknown error";

    public ReviewerServiceException(String message)
    {
        super(message);
    }
}
