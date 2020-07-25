package ru.levelup.covid19.covideconomicresearch.facade;

import ru.levelup.covid19.covideconomicresearch.dto.covid.GetCountryStatusByDate;
import ru.levelup.covid19.covideconomicresearch.dto.finance.GetCapDataByCompany;
import ru.levelup.covid19.covideconomicresearch.dto.research.res.CorrelationResult;

public interface ResearchFacade {
    CorrelationResult getCorrelationCovidVsFinance (GetCountryStatusByDate covidData,
                                                    GetCapDataByCompany financeData);
}
