package ru.levelup.covid19.covideconomicresearch.service.covid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import ru.levelup.covid19.covideconomicresearch.dto.covid.GetCountryLiveByDate;
import ru.levelup.covid19.covideconomicresearch.dto.covid.res.CountryCases;
import ru.levelup.covid19.covideconomicresearch.dto.finance.res.CapFinanceResult;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class CovidServiceImpl implements CovidService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${service.covid.country.live}")
    private String serviceCovidLive;

    public List<CountryCases> getCases(GetCountryLiveByDate getCountryLiveByDate) {

        UriComponentsBuilder covidRequestUri =
                UriComponentsBuilder
                        .fromUriString(serviceCovidLive)
                        .queryParam("Country", getCountryLiveByDate.getCountryName())
                        .queryParam("dateFrom", getCountryLiveByDate.getDateFrom())
                        .queryParam("dateTo", getCountryLiveByDate.getDateTo());


        ResponseEntity<CountryCases[]> countryCasesList = restTemplate.getForEntity(covidRequestUri.toUriString(),
                CountryCases[].class, 1);
        List<CountryCases> countryCases = Arrays.asList(Objects.requireNonNull(countryCasesList.getBody()));
        return countryCases;
    }
}
