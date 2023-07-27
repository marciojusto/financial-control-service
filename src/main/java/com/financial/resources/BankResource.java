package com.financial.resources;

import com.financial.entities.Bank;
import io.quarkus.hibernate.reactive.panache.Panache;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.DELETE;
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

@Path("/banks")
@ApplicationScoped
public class BankResource {

    @GET
    public Uni<List<Bank>> listAll() {
        return Bank.listAll();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<Response> create(Bank bank) {
        return Panache.withTransaction(bank::persist)
                      .replaceWith(Response.ok(bank).status(Status.CREATED)::build);
    }

    @DELETE
    @Path("/{id}")
    public Uni<Response> delete(@RestPath UUID id) {
        return Panache.withTransaction(() -> Bank.deleteById(id))
                      .map(deleted -> deleted ? Response.noContent()
                                                        .build() : Response.ok()
                                                                           .status(Status.NOT_FOUND)
                                                                           .build());
    }
}
