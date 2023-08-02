package com.financial.resources;

import com.financial.entities.SubCategory;
import io.quarkus.hibernate.reactive.rest.data.panache.PanacheEntityResource;
import io.quarkus.rest.data.panache.ResourceProperties;

import java.util.UUID;

@ResourceProperties(path = "sub-categories")
public interface SubCategoryResource extends PanacheEntityResource<SubCategory, UUID> {}
