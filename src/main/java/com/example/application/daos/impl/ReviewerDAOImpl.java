package com.example.application.daos.impl;

import com.example.application.daos.ReviewerDAO;
import com.example.application.models.entities.Reviewer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.asm.Type;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Slf4j
@Repository
@RequiredArgsConstructor
public class ReviewerDAOImpl implements ReviewerDAO
{
    protected final JdbcTemplate jdbcTemplate;

    protected final static String insertStatement = "INSERT INTO reviewer (name) VALUES (?);";
    protected final static String selectByIdStatement = "SELECT * FROM reviewer WHERE id = ?;";
    protected final static String selectAllStatement = "SELECT * FROM reviewer;";

    @Override
    public Reviewer save(Reviewer reviewer) {

        reviewer.setId((long) jdbcTemplate.update(insertStatement, reviewer.getName()));
        return reviewer;

    }

    @Override
    public Optional<Reviewer> getReviewerById(long id) {

        return Optional.ofNullable(jdbcTemplate.queryForObject(selectByIdStatement, new Object[]{id}, new int[]{Type.INT}, new BeanPropertyRowMapper<>(Reviewer.class)));

    }

    @Override
    public Collection<Reviewer> getAll() {
        return jdbcTemplate.query(selectAllStatement, new BeanPropertyRowMapper<>(Reviewer.class));
    }
}
