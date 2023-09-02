package org.impermanentplant.controller;

import org.impermanentplant.model.WeatherData;
import org.impermanentplant.model.WeatherRequest;
import org.impermanentplant.service.WeatherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest controller for weather endpoints
 */
@RestController
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    /**
     * Endpoint for getting weather data between a period of time
     * @param weatherRequest Request data for weather
     * @return Weather data retrieved using the request
     */
    @GetMapping("/weather")
    public WeatherData retrieveWeather(WeatherRequest weatherRequest) {
        return weatherService.retrieveWeatherData(weatherRequest);
    }
}
