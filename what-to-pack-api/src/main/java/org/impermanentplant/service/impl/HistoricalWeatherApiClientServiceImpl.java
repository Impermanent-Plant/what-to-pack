package org.impermanentplant.service.impl;

import org.impermanentplant.model.WeatherApiDaily;
import org.impermanentplant.model.WeatherApiResponse;
import org.impermanentplant.service.HistoricalWeatherApiClientService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 * Implementation of WeatherApiClientService to retrieve weather data from external API
 */
@Service
public class HistoricalWeatherApiClientServiceImpl implements HistoricalWeatherApiClientService {

    private final WebClient webClient;
    private final static String WEATHER_ENDPOINT_URI = "v1/archive?latitude={latitude}&longitude={longitude}&" +
            "start_date={startDate}&end_date={endDate}&daily=temperature_2m_max,temperature_2m_min," +
            "temperature_2m_mean&timezone=America/New_York";

    public HistoricalWeatherApiClientServiceImpl(WebClient.Builder webClientBuilder,
                                                 @Value("${historical-weather-api.url}") String baseUrl) {
        this.webClient = webClientBuilder.baseUrl(baseUrl).build();
    }

    /**
     * Retrieve weather data from API
     * @param latitude Latitude of location
     * @param longitude Longitude of location
     * @param startDate Start date for weather
     * @param endDate End date for weather
     * @return An object containing weather data for each day from startDate to endDate
     */
    public WeatherApiDaily retrieveHistoricalWeather(double latitude, double longitude, String startDate, String endDate) {
        Mono<WeatherApiResponse> weatherApiResponseMono = webClient.get().
                uri(WEATHER_ENDPOINT_URI, latitude, longitude, startDate, endDate).
                retrieve().bodyToMono(WeatherApiResponse.class);
        return weatherApiResponseMono.block().getDaily();
    }
}
