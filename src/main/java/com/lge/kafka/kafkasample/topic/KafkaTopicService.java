package com.lge.kafka.kafkasample.topic;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.ListTopicsResult;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.kafka.KafkaException;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.concurrent.ExecutionException;

@Slf4j
@RequiredArgsConstructor
@Service
public class KafkaTopicService {

    private final KafkaAdmin kafkaAdmin;
    private final AdminClient adminClient;

    public void createTopic(Topic topic) {
        try {
            ListTopicsResult topics = adminClient.listTopics();
            Set<String> topicNames = topics.names().get();

            if (topicNames.contains(topic.getName())) {
                throw new KafkaException("Topic already exists: " + topic.getName());
            }

            NewTopic newTopic = new NewTopic(topic.getName(), topic.getPartitions(), topic.getReplicationFactor());
            kafkaAdmin.createOrModifyTopics(newTopic);

        } catch (KafkaException e) { // exception 별도 처리
            System.out.println("Failed to create topic: " + e.getMessage());
        } catch (ExecutionException | InterruptedException e) {
            Thread.currentThread().interrupt(); // 스레드 중단 상태 복원
            System.out.println("Error while checking or creating topic: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Failed to create topic: " + e.getMessage());
        }
    }
}
