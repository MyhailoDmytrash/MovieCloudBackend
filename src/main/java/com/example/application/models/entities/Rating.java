package com.example.application.models.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import java.util.Date;

@Data
@NoArgsConstructor
public class Rating
{
    @Id
    @Column("id")
    protected Long id;

    @Column("movieId")
    protected Long movieId;

    @Column("reviewerId")
    protected Long reviewerId;

    @Column("star")
    protected Integer star;

    @Column("rating_date")
    protected Date ratingDate;
}
