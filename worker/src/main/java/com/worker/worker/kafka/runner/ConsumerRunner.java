package com.worker.worker.kafka.runner;

import com.worker.worker.kafka.consumer.KafkaMultiplyThreadConsumer;
import com.worker.worker.service.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ConsumerRunner {
    @Value("${spring.kafka.producer.bootstrap-servers}")
    private String bootstrapServer;

    @Value("${spring.kafka.consumer.client-id}")
    private String clientId;

    @Value("${spring.kafka.task.topic}")
    private String topic;

    @Autowired
    Worker worker;

    public void run(){
//        checkMemory.start();
        int numberOfThreads = 3;
        KafkaMultiplyThreadConsumer consumers = new KafkaMultiplyThreadConsumer(bootstrapServer, clientId, topic);
        consumers.execute(numberOfThreads, worker);
        try {
            Thread.sleep(100000);
        } catch (InterruptedException ie) {

        }
        consumers.shutdown();
    }
}
