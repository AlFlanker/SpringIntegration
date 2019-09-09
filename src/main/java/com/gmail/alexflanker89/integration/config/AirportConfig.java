package com.gmail.alexflanker89.integration.config;

import com.gmail.alexflanker89.integration.domain.Plane;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.messaging.MessageChannel;

@Configuration
public class AirportConfig {
    @Bean
    MessageChannel airport() {
        return new DirectChannel();
    }

    @Bean
    IntegrationFlow airportFlow() {
        return flow -> {
            flow
                    .handle("GroundService", "groundService")
                    .handle("EngineeringService", "check")
                    .channel("airport");

        };
    }

    @MessagingGateway
    public interface AirportGateway {
        @Gateway(requestChannel = "airportFlow.input")
        void process(Plane plane);
    }
}
