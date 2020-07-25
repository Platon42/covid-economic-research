package ru.levelup.covid19.covideconomicresearch;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Decimal {
    static double d = 5.77212478726E10;

    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("0", DecimalFormatSymbols.getInstance(Locale.ENGLISH));
        df.setMaximumFractionDigits(340); // 340 = DecimalFormat.DOUBLE_FRACTION_DIGITS
        System.out.println(df.format(d));
    }
}
