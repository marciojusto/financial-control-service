package com.financial.entities;

import io.quarkus.hibernate.reactive.panache.PanacheEntityBase;
import io.quarkus.hibernate.reactive.panache.common.WithTransaction;
import io.smallrye.mutiny.Uni;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.List;
import java.util.UUID;

@Entity
public class Category extends PanacheEntityBase {
    public static final int BATCH_SIZE = 50;

    @Id
    @GeneratedValue
    public UUID id;
    public String name;

    @WithTransaction
    public static Uni<Void> persistAll(List<Category> categories) {
        return getSession().chain(session -> session.setBatchSize(BATCH_SIZE)
                                                    .persistAll(categories.toArray()))
                           .replaceWithVoid();
    }
}
