package ru.levelup.covid19.covideconomicresearch.dto.spending;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
public class GetCompareBySectorData {
    private Date startFromPeriod;
    private Date endFromPeriod;
    private Date startToPeriod;
    private Date endToPeriod;
    private String economicFieldCode;
    private String currencyCode;

}
