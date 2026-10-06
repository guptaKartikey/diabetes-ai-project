package com.backend.medical.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class PredictionService {

    @Value("${python.api.url:http://127.0.0.1:5000/predict}")
    private String pythonApiUrl;

    public String getPrediction(Map<String, Object> data) {
        RestTemplate restTemplate = new RestTemplate();
        try {
            Map<?, ?> response = restTemplate.postForObject(pythonApiUrl, data, Map.class);
            if (response != null && response.containsKey("prediction")) {
                return response.get("prediction").toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Unknown";
    }
}
