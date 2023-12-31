package com.financial.enums;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class TypeEnumConverter implements AttributeConverter<TypeEnum, String> {

    @Override
    public String convertToDatabaseColumn(TypeEnum attribute) {
        if (attribute == null) {
            return null;
        }
        return attribute.getDescription();
    }

    @Override
    public TypeEnum convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }
        for (TypeEnum value : TypeEnum.values()) {
            if (value.getDescription().equals(dbData)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown enum description: " + dbData);
    }
}
