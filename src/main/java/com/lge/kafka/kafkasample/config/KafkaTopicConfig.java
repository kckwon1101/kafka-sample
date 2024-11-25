//package com.lge.kafka.kafkasample.config;
//
//import org.apache.kafka.clients.admin.AdminClient;
//import org.apache.kafka.clients.admin.AdminClientConfig;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.kafka.core.KafkaAdmin;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@Configuration
//public class KafkaTopicConfig {
//
//    private final CustomKafkaProperties kafkaProperties;
//
//    KafkaTopicConfig(CustomKafkaProperties kafkaProperties) {
//        this.kafkaProperties = kafkaProperties;
//    }
//
//    @Bean
//    public KafkaAdmin admin() {
//        Map<String, Object> configs = new HashMap<>();
//        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getBootstrapServers());
//        configs.putAll(kafkaProperties.getProperties());
//        return new KafkaAdmin(configs);
//    }
//
////    @Bean
////    public AdminClient adminClient(KafkaAdmin kafkaAdmin) {
////        return AdminClient.create(kafkaAdmin.getConfigurationProperties());
////    }
//}
