package ru.levelup.covid19.covideconomicresearch.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.levelup.covid19.covideconomicresearch.service.covid.CovidService;
import ru.levelup.covid19.covideconomicresearch.service.finance.FinanceService;
import ru.levelup.covid19.covideconomicresearch.service.spending.SpendingService;

@Service
public class ResearchFacadeImpl {

    @Autowired
    private SpendingService spendingService;

    @Autowired
    private FinanceService financeService;

    @Autowired
    private CovidService covidService;



}
