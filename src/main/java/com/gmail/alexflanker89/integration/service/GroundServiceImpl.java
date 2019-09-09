package com.gmail.alexflanker89.integration.service;

import com.gmail.alexflanker89.integration.domain.Plane;
import com.gmail.alexflanker89.integration.service.interfaces.GroundService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component("GroundService")
public class GroundServiceImpl implements GroundService {

    private void refueling(Plane plane) {
        plane.setFillFuel(true);
        log.info(plane.toString() + " are refueling");
    }


    private void antiFreezeCoating(Plane plane) {
        plane.setProtectCoating(true);
        log.info(plane.toString() + "is ready");
    }


    @Override
    public Plane groundService(Plane plane) {
        refueling(plane);
        antiFreezeCoating(plane);
        return plane;
    }
}
