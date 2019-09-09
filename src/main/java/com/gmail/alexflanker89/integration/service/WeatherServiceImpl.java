package com.gmail.alexflanker89.integration.service;

import com.gmail.alexflanker89.integration.service.interfaces.WeatherService;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component("WeatherService")
public class WeatherServiceImpl implements WeatherService {
    @Override
    public boolean icingHazard() {
        return new Random().nextBoolean();
    }
}
