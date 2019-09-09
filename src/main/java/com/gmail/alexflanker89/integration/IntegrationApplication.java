package com.gmail.alexflanker89.integration;

import com.gmail.alexflanker89.integration.config.AirportConfig;
import com.gmail.alexflanker89.integration.domain.Plane;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.integration.channel.PublishSubscribeChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@EnableIntegration
@EnableScheduling
@SpringBootApplication
@RequiredArgsConstructor
public class IntegrationApplication {
    private static final List<Plane> planes = new ArrayList<>(10);
    private final AirportConfig.RadarGateway radarGateway;

    public static void main(String[] args) {

        ConfigurableApplicationContext run = SpringApplication.run(IntegrationApplication.class, args);

        PublishSubscribeChannel outputChannel = run.getBean("airport", PublishSubscribeChannel.class);

        PublishSubscribeChannel radar = run.getBean("mainChannel", PublishSubscribeChannel.class);

        outputChannel.subscribe(x -> log.info(x.toString()));
        radar.subscribe(y -> {
                    Plane payload = (Plane) y.getPayload();
                    if (payload.getSpeed() > 0) {
                        log.warn(payload.toString());
                    }
                }
        );

        for (int i = 0; i < 10; i++) {
            planes.add(new Plane(i + 1));
        }
        planes.forEach(plane -> run.getBean(AirportConfig.AirportGateway.class).process(plane));


    }

    // цикл обновлений данных радара
    @Scheduled(fixedRate = 5000)
    public void radarUpdateTimer() {
        planes.forEach(plane -> radarGateway.getSpeed(plane));

    }

}
