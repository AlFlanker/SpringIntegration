package com.gmail.alexflanker89.integration.service.interfaces;

import com.gmail.alexflanker89.integration.domain.Plane;

public interface DispatcherService {
    void getWeatherForecast();
    void setFlyMission(Plane plane);
}
