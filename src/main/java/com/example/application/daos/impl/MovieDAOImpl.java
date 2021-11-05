package com.example.application.daos.impl;

import com.example.application.daos.MovieDAO;
import com.example.application.models.entities.Movie;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Slf4j
@Repository
@RequiredArgsConstructor
public class MovieDAOImpl implements MovieDAO
{
    protected final JdbcTemplate jdbcTemplate;

    protected final static String insertStatement = "INSERT INTO movie (title, imgURL, year, director) VALUES (?, ?, ?, ?);";
    protected final static String selectByIdStatement = "SELECT * FROM movie WHERE id = ?;";
    protected final static String selectAllStatement = "SELECT * FROM movie;";
    protected final static String deleteByIdStatement = "DELETE FROM movie WHERE id = ?;";
    protected final static String updateStatement = "UPDATE movie SET title = ?, imgURL = ?, year = ?, director = ? WHERE id = ?;";

    @Override
    public Optional<Movie> save(Movie movie) {

        movie.setId((long) jdbcTemplate.update(insertStatement, movie.getTitle(), movie.getImgURL(), movie.getYear(), movie.getDirector()));
        return Optional.ofNullable(movie);
    }

    @Override
    public Optional<Movie> getById(long id) {

        return Optional.ofNullable(jdbcTemplate.queryForObject(selectByIdStatement, new Object[]{id}, new BeanPropertyRowMapper<>(Movie.class)));
    }

    @Override
    public List<Movie> getAll()
    {
        return jdbcTemplate.query(selectAllStatement, new BeanPropertyRowMapper<>(Movie.class));
    }

    @Override
    public void removeById(Long id) {
        jdbcTemplate.update(deleteByIdStatement, id);
    }

    @Override
    public Optional<Movie> update(@NonNull Movie movie) {
        return jdbcTemplate.update(updateStatement, movie.getTitle(), movie.getImgURL(), movie.getYear(), movie.getDirector(), movie.getId()) == 1 ? Optional.of(movie) : Optional.empty();
    }
}
