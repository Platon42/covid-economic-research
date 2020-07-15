package ru.levelup.covid19.covideconomicresearch.service.spending;

import ru.levelup.covid19.covideconomicresearch.dto.spending.DataSpendingProvider;
import ru.levelup.covid19.covideconomicresearch.dto.spending.GetSpendingData;

public interface SpendingService {
    public DataSpendingProvider getSpendingData (GetSpendingData getSpendingData);
}
