package ru.levelup.covid19.covideconomicresearch.dto.covid.res;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CountryCases {
    private String country;
    private String countryCode;
    private String lat;
    private String lon;
    private Integer cases;
    private String status;
    private String date;
}
