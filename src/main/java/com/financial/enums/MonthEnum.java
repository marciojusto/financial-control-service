package com.financial.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.Month;

@Getter
@AllArgsConstructor
public enum MonthEnum {
    JAN(Month.JANUARY),
    FEV(Month.FEBRUARY),
    MAR(Month.MARCH),
    APR(Month.APRIL),
    MAY(Month.MAY),
    JUN(Month.JUNE),
    JUL(Month.JULY),
    AUG(Month.AUGUST),
    SEP(Month.SEPTEMBER),
    OCT(Month.OCTOBER),
    NOV(Month.NOVEMBER),
    DEC(Month.DECEMBER);

    private final Month description;
}
