package com.example.application.controllers;

import com.example.application.models.entities.Rating;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/rating")
public interface RatingController
{
    @PostMapping("/save")
    ResponseEntity<Object> save(@RequestBody Rating rating);

    @GetMapping("/get/by-movie-id/{movieId}")
    ResponseEntity<Object> getByMovieId(@PathVariable("movieId") long movieId);
}
