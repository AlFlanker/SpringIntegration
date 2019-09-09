package com.gmail.alexflanker89.integration.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Plane {
    private long id;
    private String flyMission;
    private boolean boardSystem;
    private boolean fillFuel;
    private boolean protectCoating;
    private FlyPhase flyPhase;
    private Integer speed;

    @Override
    public String toString() {
        return "Plane with" +
                " id =" + id +
                ", flyMission=" + flyMission + " , speed = " + speed + " км/ч";
    }

    public Plane(long id) {
        this.id = id;
    }
}
