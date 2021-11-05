package com.example.application.controllers.impl;

import com.example.application.controllers.MovieController;
import com.example.application.exceptions.MovieServiceException;
import com.example.application.models.entities.Movie;
import com.example.application.services.MovieService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class MovieControllerImpl implements MovieController
{
    protected final MovieService movieService;

    @Override
    public ResponseEntity<Object> save(@NonNull Movie movie) {
        try
        {
            return new ResponseEntity<>(movieService.save(movie), HttpStatus.OK);
        }
        catch (MovieServiceException exception)
        {
            return new ResponseEntity<>(Map.of("error", exception.getMessage()), HttpStatus.CONFLICT);
        }
    }

    @Override
    public ResponseEntity<Collection<Movie>> getAll() {
        return new ResponseEntity<>(movieService.getAllMovie(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> remove(Long id) {
        try
        {
            movieService.removeById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (DataAccessException exception)
        {
            return new ResponseEntity<>(Map.of("error", exception.getMessage()), HttpStatus.CONFLICT);
        }
    }

    @Override
    public ResponseEntity<Object> update(Movie movie) {
        try
        {
            return new ResponseEntity<>(movieService.update(movie), HttpStatus.OK);
        }
        catch (MovieServiceException exception)
        {
            return new ResponseEntity<>(Map.of("error", exception.getMessage()), HttpStatus.CONFLICT);
        }
    }

    @Override
    public ResponseEntity<Object> get(Long id)
    {
        try
        {
            return new ResponseEntity<>(movieService.getById(id), HttpStatus.OK);
        }
        catch (MovieServiceException exception)
        {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.CONFLICT);
        }
    }
}
