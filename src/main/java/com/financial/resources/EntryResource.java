package com.financial.resources;

import com.financial.entities.Entry;
import com.financial.servicies.EntryService;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static jakarta.ws.rs.core.Response.Status.CREATED;

@Path("/entries")
@RequiredArgsConstructor
public class EntryResource {

    private final EntryService service;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<Response> create(Entry entry) {
        return service.create(entry)
                      .onItem()
                      .transform(entryUni -> Response.status(CREATED)
                                                     .entity(entryUni)
                                                     .build());
    }

    @GET
    @Path("/period")
    public Uni<List<Entry>> findByPeriod(Entry entry) {
        return service.findByPeriod(entry);
    }
}
