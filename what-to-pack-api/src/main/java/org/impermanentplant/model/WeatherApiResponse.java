package org.impermanentplant.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Response from weather API
 */
@Getter
@Setter
public class WeatherApiResponse {
    private WeatherApiDaily daily;
}
