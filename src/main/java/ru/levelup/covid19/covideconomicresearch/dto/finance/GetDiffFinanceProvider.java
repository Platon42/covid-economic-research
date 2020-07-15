package ru.levelup.covid19.covideconomicresearch.dto.finance;

import lombok.Data;

import java.util.Date;

@Data
public class GetDiffFinanceProvider {
    private String startFromPeriod;
    private String endFromPeriod;
    private String startToPeriod;
    private String endToPeriod;
    private String mmvbIndex;
}
