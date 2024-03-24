package com.example.jpaex.Model;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Wishlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull(message = "category id cannot be null")
    @Column(columnDefinition = "int not null")
    private Integer uid;
    @NotNull(message = "category id cannot be null")
    @Column(columnDefinition = "int not null")
    private Integer pid;
}
