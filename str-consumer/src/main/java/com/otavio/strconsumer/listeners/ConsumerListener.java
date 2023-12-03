package com.otavio.strconsumer.listeners;

import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class ConsumerListener {
    @KafkaListener(groupId = "group-0", topics = "str-topic", containerFactory = "containerFactory")
    public void create(String message){
        log.info("CREATED ::: Received message: {}", message);
    }

    @KafkaListener(groupId = "group-1", topics = "str-topic", containerFactory = "containerFactory")
    public void log(String message){
        log.info("LOG ::: Received message: {}", message);

    }

    @KafkaListener(groupId = "group-2", topics = "str-topic", containerFactory = "containerFactory")
    public void history(String message){
        log.info("HISTORY ::: Received message: {}", message);
    }
}
