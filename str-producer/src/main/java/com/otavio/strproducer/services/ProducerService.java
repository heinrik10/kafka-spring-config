package com.otavio.strproducer.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class ProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Value("${topic.name}")
    private String topicName;

    public void sendMessage(String message){
        kafkaTemplate.send(topicName, message).addCallback(
                success -> {
                    if(success != null) {
                        log.info("Send message with sucess {}", message);
                        log.info("Partition {}", success.getRecordMetadata().partition());
                        log.info("OffSet {}", success.getRecordMetadata().offset());
                        }
                    },
                error -> log.error("Error sending message")
        );
    }
}
