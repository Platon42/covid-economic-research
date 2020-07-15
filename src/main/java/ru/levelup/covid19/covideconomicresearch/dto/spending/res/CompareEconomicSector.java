package ru.levelup.covid19.covideconomicresearch.dto.spending.res;

import lombok.Data;

import java.util.Date;

@Data
public class CompareEconomicSector {

    private String economicSectorDescription;
    private String economicCode;
    private Date startFromPeriod;
    private Date endFromPeriod;
    private Date startToPeriod;
    private Date endToPeriod;
    private String economicFieldCode;
    private String currencyCode;
    private Integer fromPeriodQuantityContracts;
    private Integer toPeriodQuantityContracts;
    private Long fromAmount;
    private Long toAmount;
    private Double contractPercentage;
    private Double amountPercentage;
}
