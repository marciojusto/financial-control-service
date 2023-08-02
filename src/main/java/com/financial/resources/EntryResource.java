package com.financial.resources;

import com.financial.entities.Entry;
import io.quarkus.hibernate.reactive.rest.data.panache.PanacheEntityResource;
import io.quarkus.rest.data.panache.ResourceProperties;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

import java.util.List;
import java.util.UUID;

@ResourceProperties(path = "entries")
public interface EntryResource extends PanacheEntityResource<Entry, UUID> {

    @GET
    @Path("/period")
    default Uni<List<Entry>> findByPeriod(Entry entry) {
        return Entry.findByPeriod(entry);
    }
}
