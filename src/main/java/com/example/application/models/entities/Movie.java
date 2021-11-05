package com.example.application.models.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

@Data
@NoArgsConstructor
public class Movie
{
    @Id
    @Column("id")
    protected Long id;

    @Column("title")
    protected String title;

    @Column("img_url")
    protected String imgURL;

    @Column("year")
    protected Integer year;

    @Column("director")
    protected String director;
}
