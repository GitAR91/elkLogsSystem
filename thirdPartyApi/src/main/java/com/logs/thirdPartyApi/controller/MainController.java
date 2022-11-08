package com.logs.thirdPartyApi.controller;

import com.logs.thirdPartyApi.model.SomeObj;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MainController {
    @GetMapping("/")
    public ResponseEntity<SomeObj> getObject(){
        log.info("On third-party controller");
        SomeObj result = new SomeObj(UUID.randomUUID(), "response text");
        return ResponseEntity.ok(result);
    }
}
