package com.openweathermap.service;

import com.openweathermap.model.WeatherResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

@Service
public class WeatherService {

    @Value("${openweathermap.api.key}")
    private String apiKey;

    @Value("${openweathermap.api.url}")
    private String apiUrl;

    private final RestTemplate restTemplate;

    public WeatherService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

public WeatherResponse getWeather(String city) {
        String url = UriComponentsBuilder.fromHttpUrl(apiUrl)
                .queryParam("q", city)
                .queryParam("appid", apiKey)
                .queryParam("units", "metric")
                .toUriString();

        Map<String, Object> response = restTemplate.getForObject(url, Map.class);

        if (response == null || response.get("main") == null || response.get("weather") == null) {
            throw new RuntimeException("No weather data found.");
        }

        Map<String, Object> main = (Map<String, Object>) response.get("main");
        Map<String, Object> weather = ((java.util.List<Map<String, Object>>) response.get("weather")).get(0);

        WeatherResponse weatherResponse = new WeatherResponse();
        weatherResponse.setCity(city);
        weatherResponse.setDescription((String) weather.get("description"));
        weatherResponse.setTemperature((Double) main.get("temp"));

        return weatherResponse;
    }

}
