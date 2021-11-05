package com.example.application.exceptions;

public class MovieServiceException extends Throwable
{
    public static final String CAN_NOT_ADD_MOVIE = "Can't add movie";
    public static final String CAN_NOT_UPDATE_MOVIE = "Can't update movie";
    public static final String MOVIE_NOT_FOUND = "Movie not found";
    public static final String UNKNOWN_ERROR = "Unknown error";

    public MovieServiceException(String message)
    {
        super(message);
    }
}
