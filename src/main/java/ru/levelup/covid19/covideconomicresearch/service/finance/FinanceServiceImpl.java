package ru.levelup.covid19.covideconomicresearch.service.finance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.levelup.covid19.covideconomicresearch.dto.finance.GetCapDataByCompany;
import ru.levelup.covid19.covideconomicresearch.dto.finance.res.CapFinanceResult;
import ru.levelup.covid19.covideconomicresearch.dto.finance.res.DiffFinanceResult;
import ru.levelup.covid19.covideconomicresearch.dto.finance.GetDiffFinanceProvider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class FinanceServiceImpl implements FinanceService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${service.finace.mmvb.diff}")
    private String serviceMmmvbDiff;

    @Value("${service.finace.mmvb.cap}")
    private String serviceMmmvbCap;

    public DiffFinanceResult getDiffData (GetDiffFinanceProvider getDiffFinanceProvider) {

        DiffFinanceResult diffFinanceResult = restTemplate.postForObject(serviceMmmvbDiff,
                getDiffFinanceProvider,
                DiffFinanceResult.class, 1);

        return diffFinanceResult;
    }

    public List<CapFinanceResult> getMarketCap (GetCapDataByCompany getCapDataByCompany) {

        CapFinanceResult[] capFinanceResults = restTemplate.postForObject(serviceMmmvbCap,
                getCapDataByCompany,
                CapFinanceResult[].class, 1);

        List<CapFinanceResult> capFinanceResultList = Arrays.asList(Objects.requireNonNull(capFinanceResults));
        return capFinanceResultList;

    }
}
