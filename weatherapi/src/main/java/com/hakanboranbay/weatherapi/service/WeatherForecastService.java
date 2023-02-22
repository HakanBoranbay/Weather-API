package com.hakanboranbay.weatherapi.service;

import com.hakanboranbay.weatherapi.mapper.WeatherForecastMapper;
import com.hakanboranbay.weatherapi.model.WeatherForecast;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * This service class provides methods get methods for daily, weekly, and monthly forecasts.
 */
@Component
public class WeatherForecastService implements IWeatherForecastService {

    @Autowired
    private RestTemplate template;

    @Override
    public List<WeatherForecast> getTodaysWeatherForecast(String cityName) {
        return getForecast(cityName, "today");
    }

    @Override
    public List<WeatherForecast> getWeeklyWeatherForecast(String cityName) {
        return getForecast(cityName, "next7days");
    }

    @Override
    public List<WeatherForecast> getMonthlyWeatherForecast(String cityName) {
        return getForecast(cityName, "next30days");
    }

    private List<WeatherForecast> getForecast(String cityName, String timePeriod) {
        String url = buildUrl(cityName, timePeriod);
        String response = template.getForObject(url, String.class);
        return WeatherForecastMapper.jsonToObject(response);
    }

    private String buildUrl(String cityName, String timePeriod) {
        return "https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/" + cityName
                + "/" + timePeriod
                + "?unitGroup=metric&key=WQF4SYPKSTR5F8M4FLQLZYZT3&contentType=json";
    }

}
