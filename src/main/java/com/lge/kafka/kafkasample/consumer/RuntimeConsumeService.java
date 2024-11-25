package com.lge.kafka.kafkasample.consumer;

import com.lge.kafka.kafkasample.config.RuntimeKafkaListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.listener.MessageListener;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class RuntimeConsumeService {

    private static final Logger LOG = LoggerFactory.getLogger(RuntimeConsumeService.class.getName());

    private final RuntimeKafkaListener runtimeKafkaListener;

    RuntimeConsumeService(final KafkaListenerContainerFactory kafkaListenerContainerFactory) {
        this.runtimeKafkaListener = new RuntimeKafkaListener(kafkaListenerContainerFactory);
    }

    public void start() {
        runtimeKafkaListener.start();
    }

    public void stop() {
        runtimeKafkaListener.stop();
    }

    public void registerListener(final Set<String> topic) {
        runtimeKafkaListener.register(() -> topic, () -> messageListener());
    }

    public void deRegisterListener(final Set<String> topic) {
        runtimeKafkaListener.deRegister(() -> topic);
    }

    private MessageListener<Object, Object> messageListener() {
        return (record) -> LOG.info("Order listened : {}", record.toString());
    }
}
