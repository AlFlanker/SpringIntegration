package com.gmail.alexflanker89.integration.service;

import com.gmail.alexflanker89.integration.domain.FlyPhase;
import com.gmail.alexflanker89.integration.domain.Plane;
import com.gmail.alexflanker89.integration.service.interfaces.RadarService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Random;

@Slf4j
@Component("RadarService")
public class RadarServiceImpl implements RadarService {

    @Override
    public Plane getSpeed(Plane plane) {
        if (Objects.nonNull(plane.getFlyPhase()) &&
                plane.getFlyPhase().equals(FlyPhase.FLY)) {
            Random rnd = new Random(System.currentTimeMillis());
            plane.setSpeed(200 + rnd.nextInt(499));
            return plane;
        }
        plane.setSpeed(0);
        return plane;
    }


}
