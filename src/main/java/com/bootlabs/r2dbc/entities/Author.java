package com.bootlabs.r2dbc.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import jakarta.validation.constraints.NotBlank;

@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Author {

    @Id
    private Long id;

    @NotBlank
    private String lastname;

    private String firstname;

}
