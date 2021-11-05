package com.example.application.controllers;

import com.example.application.models.entities.Reviewer;
import lombok.NonNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/reviewer")
public interface ReviewerController
{
    @PostMapping("/create")
    ResponseEntity<Object> create(@NonNull @RequestBody Reviewer reviewer);

    @GetMapping("/all")
    ResponseEntity<Collection<Reviewer>> getAll();

    @GetMapping("/{id}")
    ResponseEntity<Object> getById(@PathVariable("id") long id);
}
