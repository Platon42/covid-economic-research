package ru.levelup.covid19.covideconomicresearch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.levelup.covid19.covideconomicresearch.dto.covid.GetCountryStatusByDate;
import ru.levelup.covid19.covideconomicresearch.dto.finance.GetCapDataByCompany;
import ru.levelup.covid19.covideconomicresearch.dto.research.res.CorrelationResult;
import ru.levelup.covid19.covideconomicresearch.facade.ResearchFacade;

@Controller
public class AppController {

    @Autowired
    private ResearchFacade researchFacade;

    @CrossOrigin
    @GetMapping("/get-correlation")
    public @ResponseBody CorrelationResult getCorrelation (
            @RequestParam("country") String countryName,
            @RequestParam("covidStatus") String covidStatus,
            @RequestParam("company") String companyName,
            @RequestParam("dateFrom") String dateFrom,
            @RequestParam("dateTo") String dateTo) {

        GetCountryStatusByDate countryLiveByDate = new GetCountryStatusByDate(
                countryName,
                covidStatus,
                dateFrom,
                dateTo);
        GetCapDataByCompany capDataByCompany = new GetCapDataByCompany(
                "mmvb",
                dateFrom,
                dateTo,
                companyName);

        return researchFacade.getCorrelationCovidVsFinance(countryLiveByDate, capDataByCompany);
    }
}
