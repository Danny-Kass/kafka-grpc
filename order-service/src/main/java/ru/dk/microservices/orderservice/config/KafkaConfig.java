package ru.dk.microservices.orderservice.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.config.TopicConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {
    @Bean
    NewTopic createTopic() {
        return TopicBuilder.name("book-created-topic")
                .partitions(1)
                .replicas(1)
                .config(TopicConfig.MIN_IN_SYNC_REPLICAS_CONFIG, "1")
                .build();
    }
}
