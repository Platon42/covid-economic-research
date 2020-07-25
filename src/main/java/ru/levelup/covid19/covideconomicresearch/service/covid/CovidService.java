package ru.levelup.covid19.covideconomicresearch.service.covid;

import ru.levelup.covid19.covideconomicresearch.dto.covid.GetCountryStatusByDate;
import ru.levelup.covid19.covideconomicresearch.dto.covid.res.CountryCase;

import java.util.List;

public interface CovidService {
    List<CountryCase> getCases(GetCountryStatusByDate getCountryStatusByDate);
}
