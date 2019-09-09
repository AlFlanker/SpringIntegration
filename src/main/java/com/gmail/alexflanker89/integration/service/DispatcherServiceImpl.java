package com.gmail.alexflanker89.integration.service;

import com.gmail.alexflanker89.integration.domain.Plane;
import com.gmail.alexflanker89.integration.service.interfaces.DispatcherService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Random;

@Slf4j
@Component("DispatcherService")
@RequiredArgsConstructor
public class DispatcherServiceImpl implements DispatcherService {


    @Override
    public Plane setFlyMission(Plane plane) {

        if (new Random().nextBoolean()) {
            plane.setFlyMission("Kranodar - Moscow");
        } else {
            plane.setFlyMission("Sochi - Krasnodar");
        }
        log.info(plane.toString());
        return plane;

    }
}
