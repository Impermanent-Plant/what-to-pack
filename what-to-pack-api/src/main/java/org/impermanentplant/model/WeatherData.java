package org.impermanentplant.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Stores a list of days weather data
 */
@Getter
@Setter
public class WeatherData {
    private List<WeatherDataDay> weatherDataDays;
    private WeatherRequest weatherRequest;
}
