package ru.levelup.covid19.covideconomicresearch.dto.finance;

import lombok.Data;

import java.util.Date;

@Data
public class GetFinanceDataBySector {
    private Date startPeriod;
    private Date endPeriod;
    private String economicFieldCode;
    private Integer trend;
}
