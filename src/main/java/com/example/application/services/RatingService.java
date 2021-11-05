package com.example.application.services;

import com.example.application.exceptions.RatingServiceException;
import com.example.application.models.entities.Rating;
import lombok.NonNull;
import org.springframework.data.relational.core.mapping.Column;

import java.util.Collection;

public interface RatingService
{
    Rating save(@NonNull final Rating rating) throws RatingServiceException;
    Collection<Rating> getByMovieId(final long id) throws RatingServiceException;
}
