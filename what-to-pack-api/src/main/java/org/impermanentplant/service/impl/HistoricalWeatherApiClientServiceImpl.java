package org.impermanentplant.service.impl;

import org.impermanentplant.model.WeatherApiDaily;
import org.impermanentplant.model.WeatherRequest;
import org.impermanentplant.model.WeatherApiResponse;
import org.impermanentplant.service.HistoricalWeatherApiClientService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 * Implementation of WeatherApiClientService to retrieve historical weather data from external API
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
     * @param weatherRequest request parameters for API call
     * @return An object containing weather data for each day from startDate to endDate
     */
    public WeatherApiDaily retrieveHistoricalWeather(WeatherRequest weatherRequest) {
        Mono<WeatherApiResponse> weatherApiResponseMono = webClient.get().
                uri(WEATHER_ENDPOINT_URI,
                        weatherRequest.getLatitude(),
                        weatherRequest.getLongitude(),
                        weatherRequest.getStartDate(),
                        weatherRequest.getEndDate()).
                retrieve().bodyToMono(WeatherApiResponse.class);
        return weatherApiResponseMono.block().getDaily();
    }
}
