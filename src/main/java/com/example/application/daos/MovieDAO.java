package com.example.application.daos;

import com.example.application.models.entities.Movie;
import lombok.NonNull;

import java.util.List;
import java.util.Optional;

public interface MovieDAO
{
    Optional<Movie> save(@NonNull final Movie movie);
    Optional<Movie> getById(final long id);

    List<Movie> getAll();

    void removeById(@NonNull final Long id);

    Optional<Movie> update(@NonNull final Movie movie);
}
