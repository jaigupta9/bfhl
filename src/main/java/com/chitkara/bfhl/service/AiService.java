package com.chitkara.bfhl.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AiService {

    @Value("${GEMINI_API_KEY}")
    private String apiKey;

    public String askAI(String question) {

        String url = "https://generativelanguage.googleapis.com/v1/models/gemini-1.5-flash-latest:generateText?key="
                + apiKey;

        Map<String, Object> body = new HashMap<>();
        body.put("prompt", Map.of("text", question));

        RestTemplate restTemplate = new RestTemplate();
        Map response = restTemplate.postForObject(url, body, Map.class);

        /*
         * Expected response:
         * {
         * "candidates": [
         * {
         * "output": "Mumbai"
         * }
         * ]
         * }
         */

        List candidates = (List) response.get("candidates");
        Map first = (Map) candidates.get(0);
        String answer = first.get("output").toString().trim();

        // single-word only
        return answer.split("\\s+")[0];
    }
}
