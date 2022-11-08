package com.elkSystem.elkLogSystem.models.impl;

import com.elkSystem.elkLogSystem.models.LoggingObj;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
public class ThirdPartyObject implements LoggingObj {
    UUID id;
    String text;

    @Override
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
