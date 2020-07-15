package ru.levelup.covid19.covideconomicresearch.dto.spending;

import lombok.Data;

import java.util.Date;

@Data
public class DataSpendingProvider {
    private Date startFromPeriod;
    private Date endFromPeriod;
    private Date startToPeriod;
    private Date endToPeriod;
    private String economicFieldCode;
    private String currencyCode;
    private Integer influencePercentage;
    private Long fromAmount;
    private Long toAmount;
}
