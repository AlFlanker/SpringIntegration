package com.gmail.alexflanker89.integration.service.interfaces;

import com.gmail.alexflanker89.integration.domain.Plane;

public interface RadarService {
    Plane getSpeed(Plane plane);
}
