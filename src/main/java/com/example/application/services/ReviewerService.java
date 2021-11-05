package com.example.application.services;

import com.example.application.exceptions.ReviewerServiceException;
import com.example.application.models.entities.Reviewer;
import lombok.NonNull;

import java.util.Collection;

public interface ReviewerService
{
    Reviewer create(@NonNull final Reviewer reviewer) throws ReviewerServiceException;
    Reviewer getById(final long id) throws ReviewerServiceException;
    Collection<Reviewer> getAll();
}
