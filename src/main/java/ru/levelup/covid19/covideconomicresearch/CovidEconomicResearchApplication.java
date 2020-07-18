package ru.levelup.covid19.covideconomicresearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class CovidEconomicResearchApplication {
	public static void main(String[] args) {
		SpringApplication.run(CovidEconomicResearchApplication.class, args);
	}
}
