package ru.levelup.covid19.covideconomicresearch.facade;

import ru.levelup.covid19.covideconomicresearch.dto.covid.GetCountryLiveByDate;
import ru.levelup.covid19.covideconomicresearch.dto.finance.GetCapDataByCompany;
import ru.levelup.covid19.covideconomicresearch.dto.research.res.CorrelationResult;

public interface ResearchFacade {
    CorrelationResult getCorrelationCovidVsFinance (GetCountryLiveByDate covidData,
                                                    GetCapDataByCompany financeData);
}
