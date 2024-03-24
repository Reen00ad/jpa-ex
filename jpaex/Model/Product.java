package com.example.jpaex.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "name cannot be empty")
    @Size(min = 3,message = "name must be more than 3 character")
    @Column(columnDefinition = "varchar(10) not null unique")
    private String name;
    @NotNull(message = "price cannot be null")
    @Positive
    @Column(columnDefinition = "int not null")
    private double price;
    @NotNull(message = "category id cannot be null")
    @Column(columnDefinition = "int not null")
    private Integer categoryid;
}
