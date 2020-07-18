package ru.levelup.covid19.covideconomicresearch.service.finance;

import ru.levelup.covid19.covideconomicresearch.dto.finance.GetCapDataByCompany;
import ru.levelup.covid19.covideconomicresearch.dto.finance.GetDiffFinanceProvider;
import ru.levelup.covid19.covideconomicresearch.dto.finance.res.CapFinanceResult;
import ru.levelup.covid19.covideconomicresearch.dto.finance.res.DiffFinanceResult;

import java.util.List;

public interface FinanceService {
    List<CapFinanceResult> getMarketCap (GetCapDataByCompany getCapDataByCompany);
    DiffFinanceResult getDiffData (GetDiffFinanceProvider getDiffFinanceProvider);
}
