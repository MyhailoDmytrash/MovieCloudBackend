package com.example.application.controllers.impl;

import com.example.application.controllers.ReviewerController;
import com.example.application.exceptions.ReviewerServiceException;
import com.example.application.models.entities.Reviewer;
import com.example.application.services.ReviewerService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class ReviewerControllerImpl implements ReviewerController
{
    protected final ReviewerService reviewerService;

    @Override
    public ResponseEntity<Object> create(@NonNull Reviewer reviewer) {

        try
        {
            return new ResponseEntity<>(reviewerService.create(reviewer), HttpStatus.OK);
        }
        catch (ReviewerServiceException exception)
        {
            return new ResponseEntity<>(Map.of("error", exception.getMessage()), HttpStatus.CONFLICT);
        }
    }

    @Override
    public ResponseEntity<Collection<Reviewer>> getAll() {
        return new ResponseEntity<>(reviewerService.getAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> getById(long id) {
        try
        {
            return new ResponseEntity<>(reviewerService.getById(id), HttpStatus.OK);
        }
        catch (ReviewerServiceException exception)
        {
            return new ResponseEntity<>(Map.of("error", exception.getMessage()), HttpStatus.CONFLICT);
        }
    }


}
