package com.example.application.services.impl;

import com.example.application.daos.ReviewerDAO;
import com.example.application.exceptions.ReviewerServiceException;
import com.example.application.models.entities.Reviewer;
import com.example.application.services.ReviewerService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReviewerServiceImpl implements ReviewerService
{
    protected final ReviewerDAO reviewerDAO;

    @Override
    public Reviewer create(@NonNull Reviewer reviewer) throws ReviewerServiceException {

        try
        {
            return reviewerDAO.save(reviewer);
        }
        catch (DataAccessException exception)
        {
            log.error(exception.getMessage());
            throw new ReviewerServiceException(ReviewerServiceException.UNKNOWN_ERROR);
        }
    }

    @Override
    public Reviewer getById(long id) throws ReviewerServiceException {

        try
        {
            return reviewerDAO.getReviewerById(id)
                    .orElseThrow(() -> new ReviewerServiceException(ReviewerServiceException.REVIEWER_NOT_FOUND));
        }
        catch (DataAccessException exception)
        {
            log.error(exception.getMessage());
            throw  new ReviewerServiceException(ReviewerServiceException.UNKNOWN_ERROR);
        }
    }

    @Override
    public Collection<Reviewer> getAll() {
        try
        {
            return reviewerDAO.getAll();
        }
        catch (DataAccessException exception)
        {
            log.error(exception.getMessage());
            return List.of();
        }
    }
}
