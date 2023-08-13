package com.financial.dtos;

import com.financial.entities.Bank;
import com.financial.entities.Category;
import com.financial.entities.SubCategory;
import com.financial.enums.TypeEnum;

import java.sql.Date;

public record EntryDto(
        Date entryDate,
        String description,
        Double value,
        Category category,
        SubCategory subCategory,
        TypeEnum type,
        Bank bank,
        Double accountBalance
) {
}
