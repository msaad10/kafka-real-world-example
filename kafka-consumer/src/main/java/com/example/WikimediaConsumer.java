package com.example;

import com.example.entity.WikimediaData;
import com.example.repository.WikimediaDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class WikimediaConsumer {
    @Autowired
    private WikimediaDataRepository wikimediaDataRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(WikimediaConsumer.class);

    @KafkaListener(topics = "example-topic", groupId = "group_id")
    public void consume(String message) {
        LOGGER.info(String.format("#### -> Consumed message -> %s", message));
        WikimediaData wikimediaData = new WikimediaData(null, message);
        wikimediaDataRepository.save(wikimediaData);
    }
}
