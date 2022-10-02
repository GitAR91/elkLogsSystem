package com.elkSystem.elkLogSystem.conrollers;

import com.elkSystem.elkLogSystem.kafka.KafkaProducer;
import com.elkSystem.elkLogSystem.models.Task;
import com.elkSystem.elkLogSystem.service.LogGenerator;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MainController {
    Logger logger = LoggerFactory.getLogger(MainController.class);
    private final LogGenerator generator;
    private final KafkaProducer kafkaProducer;

    @GetMapping("/generate")
    public ResponseEntity test(@RequestParam(name = "count", defaultValue = "0") Integer count) {

        log.info("Test request received with count: {}", count);
        generator.generate(count);
        return ResponseEntity.ok("Success!");
    }

    @GetMapping("/")
    public ResponseEntity index(RequestEntity<String> request) {
        String requestID = MDC.get("CorrelationId");
        log.info("On index page");
        Task task = new Task("Some task", requestID);
        kafkaProducer.sendToWorker(task);
        return ResponseEntity.ok("Success!");
    }
}
