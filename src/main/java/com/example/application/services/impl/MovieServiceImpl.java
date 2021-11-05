package com.example.application.services.impl;

import com.example.application.daos.MovieDAO;
import com.example.application.exceptions.MovieServiceException;
import com.example.application.models.entities.Movie;
import com.example.application.services.MovieService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService
{
    protected final MovieDAO movieDAO;

    @Override
    public Movie save(Movie movie) throws MovieServiceException {

        try
        {
            return movieDAO.save(movie)
                    .orElseThrow(() -> new MovieServiceException(MovieServiceException.CAN_NOT_ADD_MOVIE));
        }
        catch (DataAccessException exception)
        {
            log.error(exception.getMessage());
            throw new MovieServiceException(MovieServiceException.UNKNOWN_ERROR);
        }
    }

    @Override
    public List<Movie> getAllMovie() {
        return movieDAO.getAll();
    }

    @Override
    public void removeById(Long id) {
        movieDAO.removeById(id);
    }

    @Override
    public Movie update(Movie movie) throws MovieServiceException {
        return movieDAO.update(movie)
                .orElseThrow(() -> new MovieServiceException(MovieServiceException.CAN_NOT_UPDATE_MOVIE));
    }

    @Override
    public Movie getById(@NonNull Long id) throws MovieServiceException {

        try
        {
            return movieDAO.getById(id)
                    .orElseThrow(() -> new MovieServiceException(MovieServiceException.MOVIE_NOT_FOUND));
        }
        catch (DataAccessException exception)
        {
            log.error(exception.getMessage());
            throw new MovieServiceException(MovieServiceException.UNKNOWN_ERROR);
        }
    }
}
