package com.gmail.alexflanker89.integration.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Plane {
    private long id;
    private String model;
    private boolean boardSystem;
    private boolean fillFuel;
    private FlyPhase flyPhase;

}
