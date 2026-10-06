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
        return restTemplate.postForObject(pythonApiUrl, data, String.class);
    }
}
