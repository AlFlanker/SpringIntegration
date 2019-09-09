package com.gmail.alexflanker89.integration;

import com.gmail.alexflanker89.integration.config.AirportConfig;
import com.gmail.alexflanker89.integration.domain.Plane;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.config.EnableIntegration;

@EnableIntegration
@SpringBootApplication
public class IntegrationApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext run = SpringApplication.run(IntegrationApplication.class, args);

        DirectChannel outputChannel = run.getBean("airport", DirectChannel.class);

        outputChannel.subscribe(x -> System.out.println(x));

        run.getBean(AirportConfig.AirportGateway.class).process(new Plane());

    }

}
