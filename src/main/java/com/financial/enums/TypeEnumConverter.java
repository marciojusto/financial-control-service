package com.financial.enums;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class TypeEnumConverter implements AttributeConverter<Type, String> {

    @Override
    public String convertToDatabaseColumn(Type attribute) {
        if (attribute == null) {
            return null;
        }
        return attribute.getDescription();
    }

    @Override
    public Type convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }
        for (Type value : Type.values()) {
            if (value.getDescription().equals(dbData)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown enum description: " + dbData);
    }
}
