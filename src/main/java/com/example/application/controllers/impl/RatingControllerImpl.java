package com.example.application.controllers.impl;

import com.example.application.controllers.RatingController;
import com.example.application.exceptions.RatingServiceException;
import com.example.application.models.entities.Rating;
import com.example.application.services.RatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RatingControllerImpl implements RatingController
{
    protected final RatingService ratingService;

    @Override
    public ResponseEntity<Object> save(Rating rating) {
        try
        {
            return new ResponseEntity<>(ratingService.save(rating), HttpStatus.OK);
        }
        catch (RatingServiceException exception)
        {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @Override
    public ResponseEntity<Object> getByMovieId(long movieId) {
        try
        {
            return new ResponseEntity<>(ratingService.getByMovieId(movieId), HttpStatus.OK);
        }
        catch (RatingServiceException exception)
        {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.CONFLICT);
        }
    }
}
