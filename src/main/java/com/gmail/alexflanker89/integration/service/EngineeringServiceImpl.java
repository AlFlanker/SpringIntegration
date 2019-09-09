package com.gmail.alexflanker89.integration.service;

import com.gmail.alexflanker89.integration.domain.Plane;
import com.gmail.alexflanker89.integration.service.interfaces.EngineeringService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component("EngineeringService")
public class EngineeringServiceImpl implements EngineeringService {

    private void checkBoardSystem(Plane plane) {
        log.info(plane.toString() + " checkBoardSystem");
    }

    private void checkEngines(Plane plane) {
        log.info(plane.toString() + " checkEngines");
    }

    @Override
    public Plane check(Plane plane) {
        checkBoardSystem(plane);
        checkEngines(plane);
        plane.setBoardSystem(true);
        return plane;
    }
}
