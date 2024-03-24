package com.example.jpaex.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class MerchantStock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull(message = "product id cannot be null")
    @Column(columnDefinition = "int not null")
    private Integer productid;
    @NotNull(message = "merchant id cannot be null")
    @Column(columnDefinition = "int not null")
    private Integer merchantid;
    @NotNull(message = "stock cannot be empty")
    @Min(value = 10,message = "stock must be more than 10 at start ")
    @Column(columnDefinition = "int not null ")
    private Integer stock;
}
