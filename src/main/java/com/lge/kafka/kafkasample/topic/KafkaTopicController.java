//package com.lge.kafka.kafkasample.topic;
//
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@Slf4j
//@RequiredArgsConstructor
//@RequestMapping("/kafka/topic")
//@RestController
//public class KafkaTopicController {
//
//    private final KafkaTopicService kafkaTopicService;
//
//    @PostMapping("/create")
//    public ResponseEntity<Void> createTopic(@RequestBody Topic topic) {
//
//        kafkaTopicService.createTopic(topic);
//        return ResponseEntity.ok().build();
//    }
//}
