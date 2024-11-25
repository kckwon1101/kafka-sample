//package com.lge.kafka.kafkasample.consumer;
//
//import org.apache.kafka.clients.consumer.ConsumerConfig;
//import org.apache.kafka.common.serialization.StringDeserializer;
//import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
//import org.springframework.kafka.listener.ContainerProperties;
//import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
//import org.springframework.kafka.core.ConsumerFactory;
//import org.springframework.kafka.listener.MessageListener;
//import org.springframework.stereotype.Service;
//
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Set;
//import java.util.concurrent.ConcurrentHashMap;
//
//@Service
//public class KafkaDynamicListenerService {
//
//    private final Map<String, ConcurrentMessageListenerContainer<String, String>> listeners = new ConcurrentHashMap<>();
//
//
//    private MessageListener<Object, Object> messageListener() {
//        return (record) -> System.out.printf("Order listened : {}", record.toString());
//    }
//
//    public void addTopicListener(String topicName) {
//        if (listeners.containsKey(topicName)) {
//            System.out.println("Listener for topic " + topicName + " already exists.");
//            return;
//        }
//
//        // 리스너 컨테이너 생성
//        ConcurrentMessageListenerContainer<String, String> container = createListenerContainer(topicName);
//
//        // 컨테이너 시작
//        container.start();
//
//        // 관리 맵에 추가
//        listeners.put(topicName, container);
//
//        System.out.println("Started listener for topic: " + topicName);
//    }
//
//    public void removeTopicListener(String topicName) {
//        ConcurrentMessageListenerContainer<String, String> container = listeners.remove(topicName);
//        if (container != null) {
//            container.stop();
//            System.out.println("Stopped listener for topic: " + topicName);
//        } else {
//            System.out.println("No listener found for topic: " + topicName);
//        }
//    }
//
//    private ConcurrentMessageListenerContainer<String, String> createListenerContainer(String topicName) {
//        // Consumer 설정
//        ConsumerFactory<String, String> consumerFactory = new DefaultKafkaConsumerFactory<>(consumerConfigs());
//
//        // 리스너 컨테이너 설정
//        ContainerProperties containerProperties = new ContainerProperties(topicName);
////        containerProperties.setMessageListener((message) -> {
////            System.out.println("Received message from topic " + topicName + ": " + message.value());
////        });
//        containerProperties.setMessageListener(messageListener());
//
//        return new ConcurrentMessageListenerContainer<>(consumerFactory, containerProperties);
//    }
//
//    private Map<String, Object> consumerConfigs() {
//        Map<String, Object> props = new HashMap<>();
//        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
//        props.put(ConsumerConfig.GROUP_ID_CONFIG, "dynamic-consumer-group");
//        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
//        return props;
//    }
//
//    public Set<String> getActiveTopics() {
//        return listeners.keySet();
//    }
//}
