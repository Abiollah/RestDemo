package com.gmail.merikbest2015.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private BigDecimal budget;
}
