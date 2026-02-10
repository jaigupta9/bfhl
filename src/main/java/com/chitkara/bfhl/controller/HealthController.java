package com.chitkara.bfhl.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
public class HealthController {

    @GetMapping("/health")
    public Map<String, Object> health() {
        return Map.of(
                "is_success", true,
                "official_email", "jai1937.be23@chitkara.edu.in");
    }
}
