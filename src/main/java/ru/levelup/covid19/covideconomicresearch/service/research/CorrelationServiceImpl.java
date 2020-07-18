package ru.levelup.covid19.covideconomicresearch.service.research;

import org.apache.commons.math3.stat.correlation.PearsonsCorrelation;
import org.apache.commons.math3.stat.correlation.SpearmansCorrelation;
import org.apache.commons.math3.stat.regression.SimpleRegression;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import ru.levelup.covid19.covideconomicresearch.dto.finance.GetDiffFinanceProvider;
import ru.levelup.covid19.covideconomicresearch.dto.research.res.CorrelationResult;
import ru.levelup.covid19.covideconomicresearch.dto.spending.GetCompareBySectorData;

@Service
public class CorrelationServiceImpl implements CorrelationService{


    public CorrelationResult showCorrelation (double[] array1, double[] array2) {
        SimpleRegression regression = getRegression(array1,array2);
        double intercept = regression.getIntercept();
        double slope = regression.getSlope();
        double spearmansCoefficient = spearmansCoefficient(array1, array2);
        double pearsonsCoefficient = pearsonsCoefficient(array1, array2);

        CorrelationResult correlationResult = new CorrelationResult();
        correlationResult.setRegressionIntercept(intercept);
        correlationResult.setRegressionSlope(slope);
        correlationResult.setSpearmansCoefficient(spearmansCoefficient);
        correlationResult.setPearsonsCoefficient(pearsonsCoefficient);
        return correlationResult;

    }

    //regression.getIntercept();
    // displays intercept of regression line
    //
    //regression.getSlope();
    // displays slope of regression line
    //
    //regression.getSlopeStdErr();
    // displays slope standard error
    private SimpleRegression getRegression (double[] array1, double[] array2) {
        SimpleRegression simpleRegression = new SimpleRegression();
        int count = Math.min(array1.length, array2.length);
        for (int i = 0; i < count; i++) {
            simpleRegression.addData(array1[i], array2[i]);
        }
        return simpleRegression;
    }


    private double spearmansCoefficient (double[] array1, double[] array2) {
        return new SpearmansCorrelation().correlation(array1, array2);
    }

    private double pearsonsCoefficient (double[] array1, double[] array2){
        return new PearsonsCorrelation().correlation(array1, array2);
    }
}
