package com.financial.resources;

import com.financial.entities.Entry;
import com.financial.servicies.EntryService;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import static jakarta.ws.rs.core.Response.Status.CREATED;

@Slf4j
@Path("/entries")
@RequiredArgsConstructor
public class EntryResource {

    private final EntryService service;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<Response> create(Entry entry) {
        return service.create(entry)
                      .onItem()
                      .transform(entryUni -> Response.status(CREATED)
                                                     .entity(entryUni)
                                                     .build());
    }

    @POST
    @Path("/sheet")
    public void uploadSheet(File fileSheet) {
        try (
                FileInputStream is = new FileInputStream(fileSheet);
                Workbook workbook = WorkbookFactory.create(is)
        ) {
            Sheet sheet = workbook.getSheetAt(0);
            sheet.forEach(row -> row.forEach(cell -> {

            }));
        }
        catch (IOException fe) {
            log.error(fe.getMessage());
        }
    }

    @GET
    @Path("/period")
    public Uni<List<Entry>> findByPeriod(Entry entry) {
        return service.findByPeriod(entry.entryDate, entry.dueDate);
    }
}
