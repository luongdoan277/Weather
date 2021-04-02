package com.example.weather.model;

public class Weather {
    private String DateTime;
    private Temperature Temperature;
    private int WeatherIcon;
    private String IconPhrase;

    public String getDateTime() {
        return DateTime;
    }

    public void setDateTime(String dateTime) {
        DateTime = dateTime;
    }

    public Temperature getTemperature() {
        return Temperature;
    }

    public void setTemperature(Temperature temperature) {
        this.Temperature = temperature;
    }

    public int getWeatherIcon() {
        return WeatherIcon;
    }

    public void setWeatherIcon(int weatherIcon) {
        WeatherIcon = weatherIcon;
    }

    public String getIconPhrase() {
        return IconPhrase;
    }

    public void setIconPhrase(String iconPhrase) {
        IconPhrase = iconPhrase;
    }
}
