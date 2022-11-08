package com.worker.worker.service;

import com.worker.worker.models.Task;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class Worker {
    Logger logger = LoggerFactory.getLogger(Worker.class);

    public void process(Task task, int count){
        try{
            Thread.sleep(1000);
            MDC.put("RequestId", task.getRequestId());
            log.info("Thread number " + count + ". In worker with task \"" + task.getTask() + "\"");
            MDC.remove("RequestId");
        } catch (Exception e){
            log.error( "Thread number " + count + ". " + e.getMessage());
        }
    }
}
