package com.example.jpaex.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "password cannot be empty")
    @Size(min = 5,message = "username must be more than 5 character")
    @Column(columnDefinition = "varchar(10) not null unique")
    private String username;
    @NotEmpty(message = "password cannot be empty")
    @Size(min = 6,message = "password must be more than 6 character")
    @Column(columnDefinition = "varchar(10) not null ")
    // @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])$")
    private String password;
    @Email
    @Column(columnDefinition = "varchar(20) not null unique")
    private String email;
    @NotEmpty(message = "role should not be null")
    @Pattern(regexp ="^(Admin|Customer)$", message = "role must be Admin or Customer only")
    @Column(columnDefinition = "varchar(8) not null ")
    private String role;
    @NotNull(message = "balance cannot be null")
    @Positive
    @Column(columnDefinition = "int not null")
    private double balance;
}
