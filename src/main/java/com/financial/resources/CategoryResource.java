package com.financial.resources;

import com.financial.entities.Category;
import io.quarkus.hibernate.reactive.rest.data.panache.PanacheEntityResource;
import io.quarkus.rest.data.panache.ResourceProperties;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

import java.util.List;
import java.util.UUID;

@ResourceProperties(path = "categories")
public interface CategoryResource extends PanacheEntityResource<Category, UUID> {

    @POST
    @Path("/batch")
    default Uni<Void> persistAll(List<Category> categories) {
        return Category.persistAll(categories);
    }
}
