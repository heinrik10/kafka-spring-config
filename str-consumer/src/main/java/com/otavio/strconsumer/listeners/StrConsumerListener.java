package com.otavio.strconsumer.listeners;

import com.otavio.strconsumer.custom.StrConsumerCustomListener;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class StrConsumerListener {

    @StrConsumerCustomListener(groupId = "group-1")
    public void create(String message){
        log.info("\nCREATED ::: Received message: {}", message);
    }

    @StrConsumerCustomListener(groupId = "group-1")
    public void log(String message){
        log.info("\nLOG ::: Received message: {}", message);

    }

    @StrConsumerCustomListener(groupId = "group-2")
    public void history(String message){
        log.info("\nHISTORY ::: Received message: {}", message);
    }
}
