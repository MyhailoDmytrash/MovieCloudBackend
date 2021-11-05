package com.example.application.daos.impl;

import com.example.application.daos.RatingDAO;
import com.example.application.models.entities.Rating;
import lombok.RequiredArgsConstructor;
import org.springframework.asm.Type;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class RatingDAOImpl implements RatingDAO
{
    protected final JdbcTemplate jdbcTemplate;

    protected final static String insertStatement = "INSERT INTO rating (movieId, reviewerId, star, ratingDate) VALUES (?, ?, ?, ?);";
    protected final static String selectByMovieIdStatement = "SELECT * FROM rating WHERE movieId = ?;";
    protected final static String deleteByReviewerIdStatement = "DELETE FROM rating WHERE reviewerId = ?;";

    @Override
    public Rating save(Rating rating) {

        jdbcTemplate.update(deleteByReviewerIdStatement, rating.getReviewerId());
        rating.setRatingDate(new Date());
        rating.setId((long) jdbcTemplate.update(insertStatement, rating.getMovieId(), rating.getReviewerId(), rating.getStar(), rating.getRatingDate()));

        return rating;
    }

    @Override
    public List<Rating> getByMovieId(long id) {
        return jdbcTemplate.query(selectByMovieIdStatement, new Object[]{id}, new int[]{Type.INT}, new BeanPropertyRowMapper<>(Rating.class));
    }
}
