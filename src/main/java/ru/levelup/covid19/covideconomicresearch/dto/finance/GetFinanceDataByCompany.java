package ru.levelup.covid19.covideconomicresearch.dto.finance;

import lombok.Data;

import java.util.Date;

@Data
public class GetFinanceDataByCompany {
    private Date startPeriod;
    private Date endPeriod;
    private String companyName;
}
