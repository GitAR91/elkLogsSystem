package com.worker.worker.kafka.handlers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.worker.worker.models.Task;
import com.worker.worker.service.Worker;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;

@RequiredArgsConstructor
public class ConsumerThreadHandler implements Runnable{
    private final ConsumerRecord consumerRecord;
    private final Worker worker;

    private final int count;

    public void run() {
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            Task task = objectMapper.readValue(consumerRecord.value().toString(), Task.class);
            worker.process(task, count);
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
