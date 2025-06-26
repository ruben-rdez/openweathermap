package com.openweathermap.model;

import lombok.Data;

@Data
public class WeatherResponse {
    private String city;
    private double temperature;
    private String description;
}
