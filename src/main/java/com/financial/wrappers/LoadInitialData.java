package com.financial.wrappers;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

@Slf4j
@ApplicationScoped
@RequiredArgsConstructor
public class LoadInitialData {

    private final ObjectMapper objectMapper;

    private File getFile(String path) {
        return new File(Objects.requireNonNull(this.getClass()
                                                   .getClassLoader()
                                                   .getResource(path))
                               .getFile());
    }

    public void loadData(@Observes StartupEvent startupEvent) throws IOException {
        log.info("Loading initial data...");
        /*List<Category> categories = objectMapper.readValue(getFile("/loadData/Categories.json"),
                                                           new TypeReference<>() {
                                                           });*/
    }
}
