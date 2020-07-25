package ru.levelup.covid19.covideconomicresearch.service.covid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import ru.levelup.covid19.covideconomicresearch.dto.covid.GetCountryStatusByDate;
import ru.levelup.covid19.covideconomicresearch.dto.covid.res.CountryCase;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class CovidServiceImpl implements CovidService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${service.covid.country.live}")
    private String serviceCovidLive;

    public List<CountryCase> getCases(GetCountryStatusByDate getCountryStatusByDate) {

        UriComponentsBuilder covidRequestUri =
                UriComponentsBuilder
                        .fromUriString(serviceCovidLive)
                        .queryParam("country", getCountryStatusByDate.getCountryName())
                        .queryParam("status", getCountryStatusByDate.getStatus())
                        .queryParam("dateFrom", getCountryStatusByDate.getDateFrom())
                        .queryParam("dateTo", getCountryStatusByDate.getDateTo());


        ResponseEntity<CountryCase[]> countryCasesList = restTemplate.getForEntity(covidRequestUri.toUriString(),
                CountryCase[].class, 1);
        List<CountryCase> countryCases = Arrays.asList(Objects.requireNonNull(countryCasesList.getBody()));
        return countryCases;
    }
}
