package com.lge.kafka.kafkasample.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Setter
@Getter
@Configuration
@ConfigurationProperties(prefix = "spring.kafka")
public class CustomKafkaProperties {

    private String bootstrapServers;
    private Map<String, String> properties;
    private Map<String, String> consumer;
}
