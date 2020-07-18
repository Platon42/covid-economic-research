package ru.levelup.covid19.covideconomicresearch.service.research;

import ru.levelup.covid19.covideconomicresearch.dto.research.res.CorrelationResult;

public interface CorrelationService {
    CorrelationResult showCorrelation (double[] array1, double[] array2);
}
