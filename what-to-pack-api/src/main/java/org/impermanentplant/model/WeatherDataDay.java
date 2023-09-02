package org.impermanentplant.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Weather data for a day
 */
@Getter
@Setter
public class WeatherDataDay {
    private String date;
    private String maxTemperature;
    private String meanTemperature;
    private String minTemperature;
}
