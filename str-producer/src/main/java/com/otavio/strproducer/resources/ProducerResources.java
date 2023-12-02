package com.otavio.strproducer.resources;

import com.otavio.strproducer.services.ProducerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producer")
@RequiredArgsConstructor
@Log4j2
public class ProducerResources {

    private final ProducerService service;

    @PostMapping
    public ResponseEntity<?> sendMessage(@RequestBody String message) throws RuntimeException {
        try{
            service.sendMessage(message);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e){
            log.error("Error sending message: {}", e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Message couldn't be sent. Please check the server logs for more details.");
        }

    }
}
