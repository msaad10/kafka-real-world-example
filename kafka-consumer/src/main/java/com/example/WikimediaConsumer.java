package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class WikimediaConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(WikimediaConsumer.class);

    @KafkaListener(topics = "example-topic", groupId = "group_id")
    public void consume(String message) {
        LOGGER.info(String.format("#### -> Consumed message -> %s", message));
    }
}
