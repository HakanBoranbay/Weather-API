package com.hakanboranbay.weatherapi.model;

/**
 * Attributes that will be shown to user when requested.
 */
public class WeatherForecast {

    private String dateTime;
    private String conditions;
    private String description;
    private String maxTemp;
    private String minTemp;

    public String getDateTime() {
        return dateTime;
    }

    public String getConditions() {
        return conditions;
    }

    public String getDescription() {
        return description;
    }

    public String getMaxTemp() {
        return maxTemp;
    }

    public String getMinTemp() {
        return minTemp;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setMaxTemp(String maxTemp) {
        this.maxTemp = maxTemp;
    }

    public void setMinTemp(String minTemp) {
        this.minTemp = minTemp;
    }
}
