package com.example.weather.model;

public class Temperature {
    private float Value;

    public Temperature(float value) {
        this.Value = value;
    }

    public float getValue() {
        return Value;
    }

    public void setValue(float value) {
        this.Value = value;
    }
}
