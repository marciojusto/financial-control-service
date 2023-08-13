package com.financial.entities;

import io.quarkus.hibernate.reactive.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;

import java.sql.Date;
import java.util.UUID;

@Entity
public class Balance extends PanacheEntityBase {

    @Id
    @GeneratedValue
    public UUID id;

    @NotNull
    public Date date;

    @NotNull
    @Column(name = "current_balance", nullable = false)
    public Double currentBalance;

    @NotNull
    @ManyToOne
    public Bank bank;
}
