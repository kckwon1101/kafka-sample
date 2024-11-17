package com.lge.kafka.kafkasample.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/kafka/producer")
@RestController
public class KafkaProducerController {

    private final KafkaProducerService kafkaProducerService;

    @PostMapping
    public ResponseEntity<Void> sendMassage(
            @RequestBody Map<String, String> messageMap) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        String message = mapper.writeValueAsString(messageMap);
        this.kafkaProducerService.sendMessageToKafka(message);
        return ResponseEntity.ok().build();
    }
}
