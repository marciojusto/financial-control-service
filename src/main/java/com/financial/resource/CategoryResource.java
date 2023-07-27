package com.financial.resource;

import com.financial.entity.Category;
import io.quarkus.hibernate.reactive.panache.Panache;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

import java.util.List;

@Path("/categories")
@ApplicationScoped
public class CategoryResource {

    @GET
    public Uni<List<Category>> listAll() {
        return Category.listAll();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<Response> create(Category category) {
        return Panache.withTransaction(category::persist)
                      .replaceWith(Response.ok(category).status(Status.CREATED)::build);
    }
}
