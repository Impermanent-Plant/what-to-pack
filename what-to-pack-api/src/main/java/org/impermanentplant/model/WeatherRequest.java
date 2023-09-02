package org.impermanentplant.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Request parameters for getting weather data
 */
@Getter
@Setter
public class WeatherRequest {
    private double latitude;
    private double longitude;
    private String startDate;
    private String endDate;
}
