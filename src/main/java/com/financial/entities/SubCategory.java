package com.financial.entities;

import io.quarkus.hibernate.reactive.panache.PanacheEntityBase;
import io.smallrye.mutiny.Uni;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "sub_category")
public class SubCategory extends PanacheEntityBase {

    @Id
    @GeneratedValue
    public UUID id;
    public String name;

    @ManyToOne(optional = false)
    public Category category;

    public static Uni<SubCategory> findById(UUID id) {
        return find("id", id).firstResult();
    }
}
