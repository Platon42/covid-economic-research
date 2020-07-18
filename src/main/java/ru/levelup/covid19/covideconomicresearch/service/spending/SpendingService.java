package ru.levelup.covid19.covideconomicresearch.service.spending;

import ru.levelup.covid19.covideconomicresearch.dto.spending.res.CompareEconomicSector;
import ru.levelup.covid19.covideconomicresearch.dto.spending.GetCompareBySectorData;

public interface SpendingService {
    CompareEconomicSector getSpendingData (GetCompareBySectorData getCompareBySectorData);
}
