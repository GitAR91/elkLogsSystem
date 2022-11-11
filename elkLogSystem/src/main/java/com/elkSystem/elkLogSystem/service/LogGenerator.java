package com.elkSystem.elkLogSystem.service;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.stream.LongStream;
@Slf4j
@Service
public class LogGenerator {
    public void generate(int count) {
        log.info("Start generating logs");
//        LongStream.range(0, count)
//                .forEach(i -> logger.info("Log {}", i));
        for(int i = 0; i < count; i++){
            try{
                log.info("Log {}", i);
                Thread.sleep(1000);
            } catch (InterruptedException ex){
                log.error("Interrupted");
            }
        }
    }
}
