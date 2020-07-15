package ru.levelup.covid19.covideconomicresearch.dto.finance.res;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class CapFinanceResult {
    private BigDecimal capitalization;
    private Date tradeDate;
}
