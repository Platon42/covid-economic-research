package ru.levelup.covid19.covideconomicresearch.service.spending;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.levelup.covid19.covideconomicresearch.dto.spending.DataSpendingProvider;
import ru.levelup.covid19.covideconomicresearch.dto.spending.GetSpendingData;

@Service
public class SpendingServiceImpl implements SpendingService {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${service.spending.url}")
    private String serviceSpendingUrl;

    public DataSpendingProvider getSpendingData (GetSpendingData getSpendingData) {
        if (!isValidDatePeriod(getSpendingData))
            return null; // не классно, нужно писать кастомные исключения

        DataSpendingProvider dataSpendingProvider =
                restTemplate.postForObject(serviceSpendingUrl,
                getSpendingData,
                DataSpendingProvider.class,
                1);
        return dataSpendingProvider;

    }

    private boolean isValidDatePeriod(GetSpendingData getSpendingData) {
        if (!getSpendingData.getStartFromPeriod().before(getSpendingData.getEndToPeriod())) {
            return false;
        }
        if (!getSpendingData.getEndFromPeriod().before(getSpendingData.getStartToPeriod())) {
            return false;
        }
        return true;
    }
}
