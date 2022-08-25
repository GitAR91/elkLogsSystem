package com.worker.worker.config;

import com.worker.worker.kafka.runner.ConsumerRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.Resource;

@Configuration
public class ApplicationConfig {

    @Resource
    private ConsumerRunner consumerRunner;

    @Scheduled(fixedDelay=Long.MAX_VALUE)
    public void runConsumer() {
        consumerRunner.run();
    }
}
