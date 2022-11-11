package com.elkSystem.elkLogSystem.models.elasticsearch;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown=true)
public class LogDocument {
    private String logLevel;

    private String logger;

    private String requestId;

    private String timestamp;

    private String objectId;

    private String text;
}
