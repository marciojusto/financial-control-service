package com.financial.wrapper;

import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.flywaydb.core.Flyway;

@Slf4j
@ApplicationScoped
public class RunFlyway {

    @ConfigProperty(name = "flyway.migrate")
    boolean migrate;

    @ConfigProperty(name = "quarkus.datasource.reactive.url")
    String datasourceUrl;

    @ConfigProperty(name = "quarkus.datasource.username")
    String username;

    @ConfigProperty(name = "quarkus.datasource.password")
    String password;

    public void runFlywayMigration(@Observes StartupEvent event) {
        if (migrate) {
            log.info("Running Flyway");
            Flyway.configure()
                  .dataSource(datasourceUrl.replace("vertx-reactive", "jdbc"), username, password)
                  .schemas("staging")
                  .load()
                  .migrate();
        }
        else {
            log.info("Not running Flyway");
        }
    }
}
