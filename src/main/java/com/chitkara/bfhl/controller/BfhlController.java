package com.chitkara.bfhl.controller;

import com.chitkara.bfhl.dto.*;
import com.chitkara.bfhl.service.AiService;
import com.chitkara.bfhl.service.BfhlService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class BfhlController {

    private final BfhlService bfhlService;
    private final AiService aiService;

    private static final String EMAIL = "jai1937.be23@chitkara.edu.in";

    public BfhlController(BfhlService bfhlService, AiService aiService) {
        this.bfhlService = bfhlService;
        this.aiService = aiService;
    }

    @PostMapping("/bfhl")
    public ApiResponse<?> handle(@RequestBody BfhlRequest request) {

        Map<String, Object> payload = request.getPayload();

        if (payload.size() != 1) {
            return new ApiResponse<>(false, EMAIL, null);
        }

        String key = payload.keySet().iterator().next();
        Object value = payload.get(key);

        switch (key) {

            case "fibonacci":
                return new ApiResponse<>(
                        true,
                        EMAIL,
                        bfhlService.fibonacci((int) value));

            case "prime":
                return new ApiResponse<>(
                        true,
                        EMAIL,
                        bfhlService.primes((List<Integer>) value));

            case "hcf":
                return new ApiResponse<>(
                        true,
                        EMAIL,
                        bfhlService.hcf((List<Integer>) value));

            case "lcm":
                return new ApiResponse<>(
                        true,
                        EMAIL,
                        bfhlService.lcm((List<Integer>) value));

            case "AI":
                try {
                    return new ApiResponse<>(
                            true,
                            EMAIL,
                            aiService.askAI(value.toString()));
                } catch (Exception e) {
                    return new ApiResponse<>(false, EMAIL, null);
                }

            default:
                return new ApiResponse<>(false, EMAIL, null);
        }
    }
}
