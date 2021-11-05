package com.example.application.daos;

import com.example.application.models.entities.Reviewer;
import lombok.NonNull;

import java.util.Collection;
import java.util.Optional;

public interface ReviewerDAO
{
    Reviewer save(@NonNull final Reviewer reviewer);
    Optional<Reviewer> getReviewerById(final long id);
    Collection<Reviewer> getAll();
}
