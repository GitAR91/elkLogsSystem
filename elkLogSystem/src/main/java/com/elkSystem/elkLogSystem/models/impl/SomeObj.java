package com.elkSystem.elkLogSystem.models.impl;

import com.elkSystem.elkLogSystem.models.LoggingObj;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class SomeObj implements LoggingObj {
    Integer id;

    String text;

    @Override
    public Integer getId() {
        return this.id;
    }

    public String getText(){
        return this.text;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }

}
