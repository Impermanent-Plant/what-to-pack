package org.impermanentplant.service.impl;

import org.impermanentplant.model.WeatherApiDaily;
import org.impermanentplant.model.WeatherData;
import org.impermanentplant.model.WeatherDataDay;
import org.impermanentplant.model.WeatherRequest;
import org.impermanentplant.service.HistoricalWeatherApiClientService;
import org.impermanentplant.service.WeatherService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of WeatherService to get weather data
 */
@Service
public class WeatherServiceImpl implements WeatherService {

    private final HistoricalWeatherApiClientService historicalWeatherApiClientService;

    public WeatherServiceImpl(HistoricalWeatherApiClientService historicalWeatherApiClientService) {
        this.historicalWeatherApiClientService = historicalWeatherApiClientService;
    }

    /**
     * Retrieves and returns weather data
     * @param weatherRequest Request for weather data
     * @return Weather data retrieved with the request passed in
     */
    public WeatherData retrieveWeatherData(WeatherRequest weatherRequest) {
        WeatherData weatherData = new WeatherData();
        weatherData.setWeatherDataDays(mapWeatherData(weatherRequest));
        weatherData.setWeatherRequest(weatherRequest);

        return weatherData;
    }

    /**
     * Gets weather data and maps it by day
     * @param weatherRequest Request for weather data
     * @return List of objects with weather data per day
     */
    private List<WeatherDataDay> mapWeatherData(WeatherRequest weatherRequest) {
        // Gets the historical weather data
        WeatherApiDaily weatherApiDaily = historicalWeatherApiClientService.retrieveHistoricalWeather(weatherRequest);

        // The data for the lists from the WeatherApiDaily are expected to be the same size and
        // data at the same indices correspond with each other
        List<String> dates = weatherApiDaily.getTimes();
        List<String> maxTemperatures = weatherApiDaily.getMaxTemperatures();
        List<String> minTemperatures = weatherApiDaily.getMeanTemperatures();
        List<String> meanTemperatures = weatherApiDaily.getMinTemperatures();

        List<WeatherDataDay> weatherDataDays = new ArrayList<>();
        for (int i = 0; i < weatherApiDaily.getTimes().size(); i++) {
            WeatherDataDay day = new WeatherDataDay();
            day.setDate(dates.get(i));
            day.setMaxTemperature(maxTemperatures.get(i));
            day.setMeanTemperature(meanTemperatures.get(i));
            day.setMinTemperature(minTemperatures.get(i));

            weatherDataDays.add(day);
        }

        return weatherDataDays;
    }

}
