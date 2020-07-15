package ru.levelup.covid19.covideconomicresearch.dto.research;

import lombok.Data;

import java.util.Date;

@Data
public class GetCorrelation {
    private Date startPeriod;
    private Date endPeriod;

}
