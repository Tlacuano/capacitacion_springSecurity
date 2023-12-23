package com.tlacuano.springsecurity.model.product;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "products")
@NoArgsConstructor
@Data
public class BeanProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    @DecimalMin(value ="0.01", message = "El precio debe ser mayor a 0")
    private double price;
}
