//package com.lge.kafka.kafkasample.consumer;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.stereotype.Service;
//
//import java.io.IOException;
//
//@Slf4j
//@Service
//public class KafkaConsumerService {
//
////    @KafkaListener(topics = {"req.test", "req.test2"}, groupId = "consumer_group01")
////    @KafkaListener(topics = {"req.test", "req.test2"})
////    public void consume(String message) throws IOException {
////        System.out.printf("[Consumed] Message : %s%n", message);
////    }
//
////    @KafkaListener(topics = {"req.test"}, groupId = "consumer_group02")
//    @KafkaListener(topics = {"req.test"})
//    public void consume2(String message) throws IOException {
//        System.out.printf("[Consumed 2] Message : %s%n", message);
//    }
//
////    @KafkaListener(topics = {"req.test2"}, groupId = "consumer_group01")
////    @KafkaListener(topics = {"req.test2"})
////    public void consume3(String message) throws IOException {
////        System.out.printf("[Consumed 3] Message : %s%n", message);
////    }
//}