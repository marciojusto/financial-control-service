package com.financial.entities;

import io.quarkus.hibernate.reactive.panache.PanacheEntityBase;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class Category extends PanacheEntityBase {

    @Id
    @GeneratedValue
    public UUID id;
    public String name;

}
