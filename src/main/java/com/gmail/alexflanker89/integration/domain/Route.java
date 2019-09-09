package com.gmail.alexflanker89.integration.domain;

import lombok.Data;

import java.util.List;

@Data
public class Route {
    private Long id;
    private List<String> points;
}
