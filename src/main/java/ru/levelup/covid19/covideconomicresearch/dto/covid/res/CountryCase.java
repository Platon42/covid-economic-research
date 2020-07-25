package ru.levelup.covid19.covideconomicresearch.dto.covid.res;

import lombok.Data;

@Data
public class CountryCase {
    private Integer cases;
    private String status;
    private String date;
}
