package com.gmail.alexflanker89.integration.service;

import com.gmail.alexflanker89.integration.service.interfaces.WeatherService;
import org.springframework.stereotype.Service;

@Service
public class WeatherServiceImpl implements WeatherService {
    @Override
    public boolean icingHazard() {
        return false;
    }
}
