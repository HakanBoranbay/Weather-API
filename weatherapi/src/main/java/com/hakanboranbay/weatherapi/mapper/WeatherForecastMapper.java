package com.hakanboranbay.weatherapi.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hakanboranbay.weatherapi.model.WeatherForecast;

import java.util.ArrayList;
import java.util.List;

/**
 * This mapper class provides a method that can map json response from the used weather api to a WeatherForecast object.
 */
public class WeatherForecastMapper {

    private WeatherForecastMapper() {
    }

    /**
     *
     * this method takes response from the weather api,
     * converts it into a WeatherForecast object,
     * and return a list of these ojects.
     *
     * @param response
     * @return
     */
    public static List<WeatherForecast> jsonToObject(String response) {
        List<WeatherForecast> forecastList = new ArrayList<>();
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode node = mapper.readTree(response);
            JsonNode daysNode = node.get("days"); // Json node that contains forecast info of days.
            for (int i = 0; i < daysNode.size(); i++) {
                WeatherForecast daily = new WeatherForecast();
                daily.setDateTime(daysNode.get(i).get("datetime").toString());
                daily.setDescription(daysNode.get(i).get("description").toString());
                daily.setConditions(daysNode.get(i).get("conditions").toString());
                daily.setMinTemp(daysNode.get(i).get("tempmin").toString());
                daily.setMaxTemp(daysNode.get(i).get("tempmax").toString());
                forecastList.add(daily);
            }
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return forecastList;
    }

}
