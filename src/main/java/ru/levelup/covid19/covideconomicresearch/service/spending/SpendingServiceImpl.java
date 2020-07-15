package ru.levelup.covid19.covideconomicresearch.service.spending;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.levelup.covid19.covideconomicresearch.dto.spending.res.CompareEconomicSector;
import ru.levelup.covid19.covideconomicresearch.dto.spending.GetCompareBySectorData;

@Service
public class SpendingServiceImpl implements SpendingService {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${service.spending.url}")
    private String serviceSpendingUrl;

    public CompareEconomicSector getSpendingData (GetCompareBySectorData getCompareBySectorData) {
        if (!isValidDatePeriod(getCompareBySectorData))
            return null; // не классно, нужно писать кастомные исключения

        CompareEconomicSector compareEconomicSector =
                restTemplate.postForObject(serviceSpendingUrl,
                        getCompareBySectorData,
                CompareEconomicSector.class,
                1);
        return compareEconomicSector;

    }

    private boolean isValidDatePeriod(GetCompareBySectorData getCompareBySectorData) {
        if (!getCompareBySectorData.getStartFromPeriod().before(getCompareBySectorData.getEndToPeriod())) {
            return false;
        }
        if (!getCompareBySectorData.getEndFromPeriod().before(getCompareBySectorData.getStartToPeriod())) {
            return false;
        }
        return true;
    }
}
