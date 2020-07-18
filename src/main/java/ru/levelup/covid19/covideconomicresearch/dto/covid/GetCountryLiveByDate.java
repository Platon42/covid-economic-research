package ru.levelup.covid19.covideconomicresearch.dto.covid;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetCountryLiveByDate {
    private String countryName;
    private String dateFrom;
    private String dateTo;
}
