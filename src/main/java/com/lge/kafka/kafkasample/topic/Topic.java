package com.lge.kafka.kafkasample.topic;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Topic {
    private String name;
    private int partitions;
    private short replicationFactor;
}
