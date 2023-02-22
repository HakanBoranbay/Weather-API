package com.hakanboranbay.weatherapi.controller;

import com.hakanboranbay.weatherapi.model.WeatherForecast;
import com.hakanboranbay.weatherapi.service.IWeatherForecastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WeatherForecastController {

    @Autowired
    IWeatherForecastService service;

    @RequestMapping(path = "/forecast/daily", method = RequestMethod.GET)
    public List<WeatherForecast> getDaily(@RequestParam(name = "city_name") String cityName) {
        return this.service.getTodaysWeatherForecast(cityName);
    }

    @RequestMapping(path = "/forecast/weekly", method = RequestMethod.GET)
    public List<WeatherForecast> getWeekly(@RequestParam(name = "city_name") String cityName) {
        return this.service.getWeeklyWeatherForecast(cityName);
    }

    @RequestMapping(path = "/forecast/monthly", method = RequestMethod.GET)
    public List<WeatherForecast> getMonthly(@RequestParam(name = "city_name") String cityName) {
        return this.service.getMonthlyWeatherForecast(cityName);
    }

}
