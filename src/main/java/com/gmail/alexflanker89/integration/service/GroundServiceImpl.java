package com.gmail.alexflanker89.integration.service;

import com.gmail.alexflanker89.integration.domain.Plane;
import com.gmail.alexflanker89.integration.service.interfaces.GroundService;
import org.springframework.stereotype.Component;

@Component("GroundService")
public class GroundServiceImpl implements GroundService {

    private void refueling(Plane plane) {
        System.out.println("refueling");
    }


    private void antiFreezeCoating(Plane plane) {
        System.out.println("antiFreezeCoating");
    }


    @Override
    public Plane groundService(Plane plane) {
        refueling(plane);
        antiFreezeCoating(plane);
        return plane;
    }
}
