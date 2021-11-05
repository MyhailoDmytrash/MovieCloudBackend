package com.example.application.controllers;

import com.example.application.models.entities.Movie;
import lombok.NonNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/movie")
public interface MovieController
{
    @PostMapping("/save")
    ResponseEntity<Object> save(@NonNull @RequestBody Movie movie);

    @GetMapping("/all")
    ResponseEntity<Collection<Movie>> getAll();

    @DeleteMapping("/remove/{id}")
    ResponseEntity<Object> remove(@PathVariable("id") Long id);

    @PostMapping("/update")
    ResponseEntity<Object> update(@RequestBody Movie movie);

    @GetMapping("/{id}")
    ResponseEntity<Object> get(@PathVariable("id") Long id);
}
