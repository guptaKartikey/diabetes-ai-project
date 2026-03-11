package com.backend.medical.service;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PythonService {

    private final String PYTHON_API_URL = "http://127.0.0.1:5000/predict";

    public String getPrediction(Object data) {

        RestTemplate restTemplate = new RestTemplate();

        String response = restTemplate.postForObject(
                PYTHON_API_URL,
                data,
                String.class
        );

        return response;
    }
}