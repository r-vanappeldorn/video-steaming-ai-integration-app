package com.microservices.accounts.dto.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public abstract class JsonObject {
    private static final ObjectMapper mapper = new ObjectMapper();

    public String toJson() {
        try {
            return mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            return "{}";
        }
    }

    @Override
    public String toString() {
        return this.toJson();
    }
}
