package com.gmail.alexflanker89.integration.service;

import com.gmail.alexflanker89.integration.domain.FlyPhase;
import com.gmail.alexflanker89.integration.domain.Plane;
import com.gmail.alexflanker89.integration.service.interfaces.AirportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
@Slf4j
@Component("AirportService")
public class AirportServiceImpl implements AirportService {


    @Override
    public Plane createFly(Plane plane)  {
        try {
            plane.setFlyPhase(FlyPhase.RACING);
            log.info("RACING");
            Thread.sleep(1000);
            plane.setFlyPhase(FlyPhase.TAKEOFF);
            log.info("TAKEOFF");
            Thread.sleep(1000);
            plane.setFlyPhase(FlyPhase.CLIMB);
            log.info("CLIMB");
            Thread.sleep(1000);
            log.info("FLY");
            plane.setFlyPhase(FlyPhase.FLY);
            return plane;
        } catch (InterruptedException e) {
            log.error(e.toString());
        }
        return plane;
    }
}
