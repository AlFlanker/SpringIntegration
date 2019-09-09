package com.gmail.alexflanker89.integration.service;

import com.gmail.alexflanker89.integration.domain.Plane;
import com.gmail.alexflanker89.integration.service.interfaces.EngineeringService;
import org.springframework.stereotype.Component;

@Component("EngineeringService")
public class EngineeringServiceImpl implements EngineeringService {

    private void checkBoardSystem(Plane plane) {
        System.out.println("checkBoardSystem");
    }

    private void checkEngines(Plane plane) {
        System.out.println("checkEngines");
    }

    @Override
    public Plane check(Plane plane) {
        checkBoardSystem(plane);
        checkEngines(plane);
        return plane;
    }
}
