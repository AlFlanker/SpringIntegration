package com.gmail.alexflanker89.integration.config;

import com.gmail.alexflanker89.integration.domain.Plane;
import com.gmail.alexflanker89.integration.service.interfaces.WeatherService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.channel.PublishSubscribeChannel;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.handler.BridgeHandler;
import org.springframework.messaging.MessageChannel;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class AirportConfig {

    private final WeatherService weatherService;

    // канал обмена данными между службами аэропорта
    @Bean
    MessageChannel airport() {
        return new PublishSubscribeChannel();
    }

    // канал радара (для простоты отдает один параметр)
    @Bean
    MessageChannel radar() {
        return new DirectChannel();
    }

    // канал один ко многим. Эмулируем выдачу данных в общий доступ
    @Bean
    MessageChannel mainChannel() {
        return new PublishSubscribeChannel();
    }

    // перекладываем из канала радара в канал общего доступа
    @Bean
    @ServiceActivator(inputChannel = "radar")
    public BridgeHandler radarData() {
        BridgeHandler bridge = new BridgeHandler();
        bridge.setOutputChannelName("mainChannel");
        return bridge;
    }

    @Bean
    IntegrationFlow radarFlow() {
        return flow -> {
            flow
                    .handle("RadarService", "getSpeed")
                    .channel("radar");
        };
    }

    @Bean
    IntegrationFlow airportFlow() {
        return flow -> {
            flow
                    .handle("GroundService", "groundService")
                    .handle("EngineeringService", "check")
                    .filter(source -> {
                        boolean weather = weatherService.icingHazard();
                        if (!weather) {
                            log.warn("Плохая погода. Рейс снят");
                        } else {
                            log.info("Погода отличная");
                        }
                        return weather;
                    })
                    .handle("DispatcherService", "setFlyMission")
                    .handle("AirportService", "createFly")
                    .channel("airport");

        };
    }

    @MessagingGateway
    public interface AirportGateway {
        @Gateway(requestChannel = "airportFlow.input")
        void process(Plane plane);
    }

    @MessagingGateway
    public interface RadarGateway {
        @Gateway(requestChannel = "radarFlow.input")
        void getSpeed(Plane plane);
    }


}
