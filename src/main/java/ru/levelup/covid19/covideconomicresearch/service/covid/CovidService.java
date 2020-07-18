package ru.levelup.covid19.covideconomicresearch.service.covid;

import ru.levelup.covid19.covideconomicresearch.dto.covid.GetCountryLiveByDate;
import ru.levelup.covid19.covideconomicresearch.dto.covid.res.CountryCases;

import java.util.List;

public interface CovidService {
    List<CountryCases> getCases(GetCountryLiveByDate getCountryLiveByDate);
}
