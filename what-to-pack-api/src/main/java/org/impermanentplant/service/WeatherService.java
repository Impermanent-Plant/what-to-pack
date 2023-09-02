package org.impermanentplant.service;

import org.impermanentplant.model.WeatherData;
import org.impermanentplant.model.WeatherRequest;

/**
 * Service for getting weather data
 */
public interface WeatherService {
    WeatherData retrieveWeatherData(WeatherRequest weatherRequest);
}
