package com.financial.servicies;

import com.financial.entities.Entry;
import com.financial.repositories.EntryRepository;
import io.quarkus.hibernate.reactive.panache.Panache;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;

import java.sql.Date;
import java.util.List;

@ApplicationScoped
@RequiredArgsConstructor
public class EntryService {

    private final EntryRepository repository;

    public Uni<Entry> create(Entry entry) {
        return Panache.withTransaction(() -> repository.persist(entry))
                      .replaceWith(entry);
    }

    public Uni<List<Entry>> findByPeriod(Date entryDate, Date dueDate) {
        return repository.findByPeriod(entryDate, dueDate);
    }
}
