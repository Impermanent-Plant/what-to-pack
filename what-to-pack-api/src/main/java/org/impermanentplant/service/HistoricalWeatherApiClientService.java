package org.impermanentplant.service;

import org.impermanentplant.model.WeatherApiDaily;
import org.impermanentplant.model.WeatherRequest;

/**
 * Service to retrieve historical weather data from external API
 */
public interface HistoricalWeatherApiClientService {
    WeatherApiDaily retrieveHistoricalWeather(WeatherRequest weatherRequest);
}
