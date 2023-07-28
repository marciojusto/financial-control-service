package com.financial.resources;

import com.financial.entities.Bank;
import io.quarkus.hibernate.reactive.rest.data.panache.PanacheEntityResource;
import io.quarkus.rest.data.panache.ResourceProperties;

import java.util.UUID;

@ResourceProperties(path = "banks")
public interface BankResource extends PanacheEntityResource<Bank, UUID> {

}
