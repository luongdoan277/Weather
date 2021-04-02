package com.example.weather.network;

import com.example.weather.model.Weather;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIManager {
    String SERVER_URL = "http://dataservice.accuweather.com/";

    @GET("forecasts/v1/hourly/12hour/353412?apikey=HUAZAP1yZIksUCxUOhaRbfhW06dp7jiE&language=vi-vn&metric=true")
    Call<List<Weather>> getWeatherData();

}
