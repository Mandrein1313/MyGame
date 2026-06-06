package com.example.mygame;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends Activity {
    private TextView tvWeather;
    private TextView tvLocation;
    private String location = "กรุงเทพมหานคร";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ตรวจสอบ Bundle savedInstanceState
        if (savedInstanceState != null) {
            location = savedInstanceState.getString("location");
        }

        tvWeather = findViewById(R.id.tvWeather);
        tvLocation = findViewById(R.id.tvLocation);

        // แสดงข้อมูลพยากรณ์อากาศ
        showWeather();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("location", location);
    }

    private void showWeather() {
        try {
            // ค้นหาข้อมูลพยากรณ์อากาศ
            WeatherInfo weatherInfo = getWeatherInfo(location);

            // แสดงข้อมูลพยากรณ์อากาศ
            tvWeather.setText(weatherInfo.getWeather());
            tvLocation.setText(location);

            // ตรวจสอบสภาพอากาศและแจ้งเตือนหากจำเป็น
            checkWeatherAlert(weatherInfo);
        } catch (Exception e) {
            Toast.makeText(this, "ข้อผิดพลาดในการค้นหาข้อมูลพยากรณ์อากาศ", Toast.LENGTH_SHORT).show();
        }
    }

    private WeatherInfo getWeatherInfo(String location) {
        // ค้นหาข้อมูลพยากรณ์อากาศจาก API หรือฐานข้อมูล
        // ในที่นี้ใช้ข้อมูลที่กำหนดไว้ล่วงหน้าเป็นตัวอย่าง
        WeatherInfo weatherInfo = new WeatherInfo();
        weatherInfo.setWeather("มีเมฆบางส่วน");
        weatherInfo.setTemperature(25);
        return weatherInfo;
    }

    private void checkWeatherAlert(WeatherInfo weatherInfo) {
        // ตรวจสอบสภาพอากาศและแจ้งเตือนหากจำเป็น
        if (weatherInfo.getWeather().contains("ฝน")) {
            Toast.makeText(this, "มีฝนตก今日", Toast.LENGTH_SHORT).show();
        } else if (weatherInfo.getTemperature() > 30) {
            Toast.makeText(this, "มีอุณหภูมิสูง今日", Toast.LENGTH_SHORT).show();
        }
    }
}

class WeatherInfo {
    private String weather;
    private int temperature;

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }
}