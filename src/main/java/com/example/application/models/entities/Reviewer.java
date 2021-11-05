package com.example.application.models.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

@Data
@NoArgsConstructor
public class Reviewer
{
    @Id
    @Column("id")
    protected Long id;

    @Column("name")
    protected String name;
}
