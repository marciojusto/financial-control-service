package com.financial.repositories;

import com.financial.entities.Entry;
import io.quarkus.hibernate.reactive.panache.PanacheRepository;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class EntryRepository implements PanacheRepository<Entry> {

    public Uni<List<Entry>> findByPeriod(Entry entry) {
        return find("entryDate >= ?1 and entryDate <= ?2", entry.entryDate, entry.dueDate).list();
    }

}
