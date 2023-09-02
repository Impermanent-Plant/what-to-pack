package org.impermanentplant.service;

import org.impermanentplant.model.WeatherApiDaily;

/**
 * Service to retrieve Weather Data from external API
 */
public interface HistoricalWeatherApiClientService {
    WeatherApiDaily retrieveHistoricalWeather(double latitude, double longitude, String startDate, String endDate);
}
