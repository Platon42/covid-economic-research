package ru.levelup.covid19.covideconomicresearch.dto.research.res;

import lombok.Data;
import org.apache.commons.math3.stat.correlation.PearsonsCorrelation;
import org.apache.commons.math3.stat.correlation.SpearmansCorrelation;
import org.apache.commons.math3.stat.regression.SimpleRegression;

@Data
public class CorrelationResult {
    //попробовать Пирсона
    //найти корр между тратами и смертностью за период
    //найти корр между фин показателями и тратами за период по сектору
    //найти корр между фин показателями и смертностью за период

    public double spearmansCoefficient (double[] array1, double[] array2) {
        return new SpearmansCorrelation().correlation(array1, array2);
    }

    public double pearsonsCoefficient (double[] array1, double[] array2){
        return new PearsonsCorrelation().correlation(array1, array2);
    }


    //regression.getIntercept();
    // displays intercept of regression line
    //
    //regression.getSlope();
    // displays slope of regression line
    //
    //regression.getSlopeStdErr();
    // displays slope standard error

    public SimpleRegression simpleRegression (double[] array1, double[] array2) {
        SimpleRegression simpleRegression = new SimpleRegression();
        int count = Math.min(array1.length, array2.length);
        for (int i = 0; i < count; i++) {
            simpleRegression.addData(array1[i], array2[i]);
        }
        return simpleRegression;
    }
}
