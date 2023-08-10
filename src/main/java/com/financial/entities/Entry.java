package com.financial.entities;

import com.financial.enums.TypeEnumConverter;
import com.financial.enums.Type;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotNull;

import java.sql.Date;
import java.util.UUID;

@Entity
@IdClass(EntryCompositeKey.class)
public class Entry {

    @Id
    @GeneratedValue
    public UUID id;

    @NotNull
    public String description;

    @Column(name = "entry_date", nullable = false)
    public Date entryDate;

    @Transient
    public Date dueDate;

    @NotNull
    public Double value;

    @NotNull
    @Convert(converter = TypeEnumConverter.class)
    public Type type;

    @ManyToOne(optional = false)
    public Bank bank;

    @ManyToOne(optional = false)
    public Category category;

    @ManyToOne(optional = false)
    public SubCategory subCategory;

}
