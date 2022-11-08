package com.elkSystem.elkLogSystem.service;

import com.elkSystem.elkLogSystem.models.impl.ThirdPartyObject;
import lombok.RequiredArgsConstructor;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Service
public class MainService {
    @Value("${thirdParty.api.url}")
    String thirdPartyUrl;

    private final RestTemplate restTemplate;

    public MainService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public ThirdPartyObject getObjectFromApi(){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set("RequestId", MDC.get("RequestId"));

        HttpEntity request = new HttpEntity(headers);

        ResponseEntity<ThirdPartyObject> response = this.restTemplate.exchange(thirdPartyUrl, HttpMethod.GET, request, ThirdPartyObject.class, 1);
        return response.getBody();
    }


}
