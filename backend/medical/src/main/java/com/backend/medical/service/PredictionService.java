package com.backend.medical.service;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class PredictionService {

    public String getPrediction(Map<String, Object> data) {

        RestTemplate restTemplate = new RestTemplate();

        String url = "http://localhost:5000/predict";

        return restTemplate.postForObject(url, data, String.class);

    }
}
