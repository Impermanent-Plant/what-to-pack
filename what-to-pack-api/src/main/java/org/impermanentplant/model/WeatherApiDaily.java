package org.impermanentplant.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Holds daily weather data from Weather API
 */
@Getter
@Setter
public class WeatherApiDaily {
    @JsonProperty("time")
    private List<String> times;
    @JsonProperty("temperature_2m_max")
    private List<String> temperatureMaxs;
    @JsonProperty("temperature_2m_min")
    private List<String> temperatureMins;
    @JsonProperty("temperature_2m_mean")
    private List<String> temperatureMeans;
}
