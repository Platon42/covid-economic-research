package ru.levelup.covid19.covideconomicresearch.dto.research.res;

import lombok.Data;
import org.apache.commons.math3.stat.correlation.PearsonsCorrelation;
import org.apache.commons.math3.stat.correlation.SpearmansCorrelation;
import org.apache.commons.math3.stat.regression.SimpleRegression;

@Data
public class CorrelationResult {
    private Double pearsonsCoefficient;
    private Double spearmansCoefficient;
    private Double regressionIntercept;
    private Double regressionSlope;
}
