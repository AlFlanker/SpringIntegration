package com.gmail.alexflanker89.integration.service;

import com.gmail.alexflanker89.integration.domain.Plane;
import com.gmail.alexflanker89.integration.service.interfaces.DispatcherService;
import com.gmail.alexflanker89.integration.service.interfaces.WeatherService;
import org.springframework.stereotype.Service;

@Service
public class DispatcherServiceImpl implements DispatcherService {

    private WeatherService weatherService;
    @Override
    public void getWeatherForecast() {
        System.out.println(weatherService.icingHazard());
    }

    @Override
    public void setFlyMission(Plane plane) {

    }
}
