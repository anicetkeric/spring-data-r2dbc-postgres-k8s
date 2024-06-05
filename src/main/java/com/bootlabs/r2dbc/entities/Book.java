package com.bootlabs.r2dbc.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    private Long id;

    @NotBlank
    @Size(max = 100)
    private String title;

    private int page;

    private String isbn;

    private String description;

    private double price;
}
