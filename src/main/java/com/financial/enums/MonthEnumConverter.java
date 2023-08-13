package com.financial.enums;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.time.Month;

@Converter(autoApply = true)
public class MonthEnumConverter implements AttributeConverter<MonthEnum, Month> {

    @Override
    public Month convertToDatabaseColumn(MonthEnum attribute) {
        if (attribute == null) {
            return null;
        }
        return attribute.getDescription();
    }

    @Override
    public MonthEnum convertToEntityAttribute(Month dbData) {
        if (dbData == null) {
            return null;
        }
        for (MonthEnum value : MonthEnum.values()) {
            if (value.getDescription().equals(dbData)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown enum description: " + dbData);
    }
}
