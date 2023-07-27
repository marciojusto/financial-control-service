package com.financial.entities;

import com.financial.enums.Type;
import io.quarkus.hibernate.reactive.panache.PanacheEntityBase;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.sql.Date;
import java.util.UUID;

@Entity
public class Entry extends PanacheEntityBase {

    @Id
    @GeneratedValue
    public UUID id;

    public String description;

    public Date date;

    public Double value;

    @Enumerated
    public Type type;

    @ManyToOne(optional = false)
    public Category category;

    @ManyToOne(optional = false)
    public SubCategory subCategory;
}
