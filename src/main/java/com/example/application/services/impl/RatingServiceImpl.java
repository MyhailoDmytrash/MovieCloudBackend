package com.example.application.services.impl;

import com.example.application.daos.RatingDAO;
import com.example.application.exceptions.RatingServiceException;
import com.example.application.models.entities.Rating;
import com.example.application.services.RatingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Slf4j
@Service
@RequiredArgsConstructor
public class RatingServiceImpl implements RatingService
{
    protected final RatingDAO ratingDAO;

    @Override
    public Rating save(Rating rating) throws RatingServiceException {

        try
        {
            return ratingDAO.save(rating);
        }
        catch (DataAccessException exception)
        {
            log.error(exception.getMessage());
            throw new RatingServiceException(RatingServiceException.UNKNOWN_ERROR);
        }
    }

    @Override
    public Collection<Rating> getByMovieId(long id) throws RatingServiceException {

        try
        {
            return ratingDAO.getByMovieId(id);
        }
        catch (DataAccessException exception)
        {
            log.error(exception.getMessage());
            throw new RatingServiceException(RatingServiceException.UNKNOWN_ERROR);
        }
    }
}
