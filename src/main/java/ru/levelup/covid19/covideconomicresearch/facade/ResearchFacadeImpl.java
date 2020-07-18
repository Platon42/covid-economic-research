package ru.levelup.covid19.covideconomicresearch.facade;

import org.apache.commons.math3.stat.correlation.PearsonsCorrelation;
import org.apache.commons.math3.stat.correlation.SpearmansCorrelation;
import org.apache.commons.math3.stat.regression.SimpleRegression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.levelup.covid19.covideconomicresearch.dto.covid.GetCountryLiveByDate;
import ru.levelup.covid19.covideconomicresearch.dto.covid.res.CountryCases;
import ru.levelup.covid19.covideconomicresearch.dto.finance.GetCapDataByCompany;
import ru.levelup.covid19.covideconomicresearch.dto.finance.GetDiffFinanceProvider;
import ru.levelup.covid19.covideconomicresearch.dto.finance.res.CapFinanceResult;
import ru.levelup.covid19.covideconomicresearch.dto.finance.res.DiffFinanceResult;
import ru.levelup.covid19.covideconomicresearch.dto.research.res.CorrelationResult;
import ru.levelup.covid19.covideconomicresearch.dto.spending.GetCompareBySectorData;
import ru.levelup.covid19.covideconomicresearch.service.covid.CovidService;
import ru.levelup.covid19.covideconomicresearch.service.finance.FinanceService;
import ru.levelup.covid19.covideconomicresearch.service.research.CorrelationService;
import ru.levelup.covid19.covideconomicresearch.service.spending.SpendingService;

import java.math.BigDecimal;
import java.nio.charset.CoderResult;
import java.util.List;

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

    public CorrelationResult getCorrelationCovidVsFinance (GetCountryLiveByDate covidData,
                                                           GetCapDataByCompany financeData) {

        List<CapFinanceResult> marketCap = financeService.getMarketCap(financeData);
        List<CountryCases> covidCases = covidService.getCases(covidData);

        double[] cases = new double[covidCases.size()];
        for (int i = 0; i < covidCases.size(); i++) {
            cases[i] = covidCases.get(i).getCases();
        }

        double[] capitalization = new double[marketCap.size()];
        for (int i = 0; i < marketCap.size(); i++) {
            capitalization[i] = marketCap.get(i).getCapitalization().doubleValue();
        }

        return correlationService.showCorrelation(cases, capitalization);
    }

}
