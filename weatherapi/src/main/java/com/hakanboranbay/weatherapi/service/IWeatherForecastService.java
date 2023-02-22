package com.hakanboranbay.weatherapi.service;

import com.hakanboranbay.weatherapi.model.WeatherForecast;

import java.util.List;

public interface IWeatherForecastService {
    List<WeatherForecast> getTodaysWeatherForecast(String cityName);
    List<WeatherForecast> getWeeklyWeatherForecast(String cityName);
    List<WeatherForecast> getMonthlyWeatherForecast(String cityName);
}
