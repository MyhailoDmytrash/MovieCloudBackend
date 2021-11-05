package com.example.application.daos;

import com.example.application.models.entities.Rating;
import lombok.NonNull;

import java.util.List;

public interface RatingDAO
{
    Rating save(@NonNull final Rating rating);
    List<Rating> getByMovieId(final long id);
}
