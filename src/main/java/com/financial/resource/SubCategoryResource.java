package com.financial.resource;

import com.financial.entity.SubCategory;
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
import org.jboss.resteasy.reactive.RestPath;

import java.util.List;
import java.util.UUID;

@Path("/sub-categories")
@ApplicationScoped
public class SubCategoryResource {

    @GET
    public Uni<List<SubCategory>> listAll() {
        return SubCategory.listAll();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<Response> create(SubCategory subCategory) {
        return Panache.withTransaction(subCategory::persist)
                      .replaceWith(Response.ok(subCategory)
                                           .status(Status.CREATED)::build);
    }

    @GET
    @Path("{id}")
    public Uni<SubCategory> findById(@RestPath UUID id) {
        return SubCategory.findById(id);
    }
}
