package com.financial.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Type {
    CREDIT("Credit"), DEBIT("Debit");

    private final String description;
}
