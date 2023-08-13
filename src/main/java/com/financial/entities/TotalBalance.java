package com.financial.entities;

import com.financial.enums.MonthEnum;
import com.financial.enums.MonthEnumConverter;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.sql.Date;
import java.util.UUID;

@Entity
@Table(name = "total_balance")
public class TotalBalance {

    @Id
    @GeneratedValue
    private UUID id;
    private Double value;
    private Date date;

    @Convert(converter = MonthEnumConverter.class)
    private MonthEnum month;
}
