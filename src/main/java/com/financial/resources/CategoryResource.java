package com.financial.resources;

import com.financial.entities.Category;
import io.quarkus.hibernate.reactive.rest.data.panache.PanacheEntityResource;
import io.quarkus.rest.data.panache.ResourceProperties;

import java.util.UUID;

@ResourceProperties(path = "categories")
public interface CategoryResource extends PanacheEntityResource<Category, UUID> {}
