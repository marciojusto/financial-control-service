package com.financial.servicies;

import com.financial.entities.Entry;
import com.financial.repositories.EntryRepository;
import io.quarkus.hibernate.reactive.panache.Panache;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class EntryService {

    @Inject
    EntryRepository repository;

    public Uni<Entry> create(Entry entry) {
        return Panache.withTransaction(() -> repository.persist(entry))
                      .replaceWith(entry);
    }

    public Uni<List<Entry>> findByPeriod(Entry entry) {
        return repository.findByPeriod(entry);
    }
}
