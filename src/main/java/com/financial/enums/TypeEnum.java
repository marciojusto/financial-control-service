package com.financial.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TypeEnum {
    CREDIT("Credit"), DEBIT("Debit");

    private final String description;
}
