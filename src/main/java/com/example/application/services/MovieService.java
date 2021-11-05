package com.example.application.services;

import com.example.application.exceptions.MovieServiceException;
import com.example.application.models.entities.Movie;
import lombok.NonNull;

import java.util.List;

public interface MovieService
{
    Movie save(@NonNull final Movie movie) throws MovieServiceException;
    List<Movie> getAllMovie();

    void removeById(@NonNull final Long id);

    Movie update(@NonNull final Movie movie) throws MovieServiceException;

    Movie getById(@NonNull final Long id) throws MovieServiceException;
}
