package com.chitkara.bfhl.dto;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import java.util.HashMap;
import java.util.Map;

public class BfhlRequest {

    private final Map<String, Object> payload = new HashMap<>();

    @JsonAnySetter
    public void set(String key, Object value) {
        payload.put(key, value);
    }

    public Map<String, Object> getPayload() {
        return payload;
    }
}
