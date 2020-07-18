package ru.levelup.covid19.covideconomicresearch.dto.finance;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetCapDataByCompany {
    private String providerName;
    private String startPeriod;
    private String endPeriod;
    private String companyName;
}
