package com.lge.kafka.kafkasample.consumer;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/kafka/topic-runtime")
public class RuntimeConsumerController {

    private final RuntimeConsumeService runtimeConsumeService;

    RuntimeConsumerController(final RuntimeConsumeService runtimeConsumeService) {
        this.runtimeConsumeService = runtimeConsumeService;
    }

    @PostMapping("/consumers/runtime/start")
    public void start() {
        runtimeConsumeService.start();
    }

    @PostMapping("/consumers/runtime/stop")
    public void stop() {
        runtimeConsumeService.stop();
    }

    @PostMapping("/consumers/runtime/register")
    public void register(@RequestBody Payload payload) {
        runtimeConsumeService.registerListener(payload.getTopics());
    }

    @PostMapping("/consumers/runtime/de-register")
    public void deRegister(@RequestBody Payload payload) {
        runtimeConsumeService.deRegisterListener(payload.getTopics());
    }

    private static class Payload {

        private Set<String> topics;

        private Payload() {}

        public Payload(final Set<String> topics) {
            this.topics = topics;
        }

        public Set<String> getTopics() {
            return topics;
        }
    }
}
