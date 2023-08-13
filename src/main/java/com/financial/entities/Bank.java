package com.financial.entities;

import io.quarkus.hibernate.reactive.panache.PanacheEntityBase;
import io.smallrye.mutiny.Uni;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class Bank extends PanacheEntityBase {

    @Id
    @GeneratedValue
    public UUID id;

    public String name;

    @Column(name = "initial_balance", nullable = false)
    public Double initialBalance;

    public static Uni<Bank> findByName(String name) {
        return find("name", name).firstResult();
    }

}
