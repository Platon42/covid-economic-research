package ru.levelup.covid19.covideconomicresearch.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.levelup.covid19.covideconomicresearch.dto.covid.GetCountryStatusByDate;
import ru.levelup.covid19.covideconomicresearch.dto.covid.res.CountryCase;
import ru.levelup.covid19.covideconomicresearch.dto.finance.GetCapDataByCompany;
import ru.levelup.covid19.covideconomicresearch.dto.finance.res.CapFinanceResult;
import ru.levelup.covid19.covideconomicresearch.dto.research.res.CorrelationResult;
import ru.levelup.covid19.covideconomicresearch.service.covid.CovidService;
import ru.levelup.covid19.covideconomicresearch.service.finance.FinanceService;
import ru.levelup.covid19.covideconomicresearch.service.research.CorrelationService;
import ru.levelup.covid19.covideconomicresearch.service.spending.SpendingService;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

@Service
public class ResearchFacadeImpl implements ResearchFacade {

    @Autowired
    private SpendingService spendingService;

    @Autowired
    private FinanceService financeService;

    @Autowired
    private CovidService covidService;

    @Autowired
    private CorrelationService correlationService;

    public CorrelationResult getCorrelationCovidVsFinance (GetCountryStatusByDate covidData,
                                                           GetCapDataByCompany financeData) {
        DecimalFormat df = new DecimalFormat("0", DecimalFormatSymbols.getInstance(Locale.ENGLISH));
        df.setMaximumFractionDigits(340); // 340 = DecimalFormat.DOUBLE_FRACTION_DIGITS

        List<CapFinanceResult> marketCap = financeService.getMarketCap(financeData);
        List<CountryCase> covidCases = covidService.getCases(covidData);

        double[] cases = new double[covidCases.size()];
        for (int i = 0; i < covidCases.size(); i++) {
            cases[i] = covidCases.get(i).getCases();
        }

        double[] capitalization = new double[marketCap.size()];
        for (int i = 0; i < marketCap.size(); i++) {
            String stringNum = df.format(marketCap.get(i).getCapitalization().doubleValue());
            capitalization[i] = Double.parseDouble(stringNum);
        }

        if (cases.length > capitalization.length) {
            cases = Arrays.copyOf(cases,capitalization.length);
        } else if (cases.length < capitalization.length) {
            capitalization = Arrays.copyOf(capitalization,cases.length);
        }

        System.out.println("cases" + Arrays.toString(cases));
        System.out.println("capitalization" + Arrays.toString(capitalization));

        return correlationService.showCorrelation(cases, capitalization);
    }

}
