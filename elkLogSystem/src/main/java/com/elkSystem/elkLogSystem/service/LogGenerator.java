package com.elkSystem.elkLogSystem.service;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.stream.LongStream;
@Slf4j
@Service
public class LogGenerator {
    Logger logger = LoggerFactory.getLogger(LogGenerator.class);
    public void generate(int count) {
        logger.info("Start generating logs");
        LongStream.range(0, count)
                .forEach(i -> logger.info("Log {}", i));
    }
}
