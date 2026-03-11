package com.backend.medical.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class AIService {

    @Value("${groq.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate = new RestTemplate();

    public String getRecommendation(Map<String, Object> patientData, String prediction) {

        String url = "https://api.groq.com/openai/v1/chat/completions";

        String prompt = "You are a medical assistant. Based on the patient data give diabetes health recommendations.\n"
                + "Prediction: " + prediction + "\n"
                + "Patient Data: " + patientData + "\n"
                + "Provide short bullet point advice.";

        Map<String, Object> request = new HashMap<>();
        request.put("model", "llama-3.1-8b-instant"); // stable model

        List<Map<String, String>> messages = new ArrayList<>();

        Map<String, String> message = new HashMap<>();
        message.put("role", "user");
        message.put("content", prompt);

        messages.add(message);
        request.put("messages", messages);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(apiKey);

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(request, headers);

        try {

            Map<String, Object> response =
                    restTemplate.postForObject(url, entity, Map.class);

            List<?> choices = (List<?>) response.get("choices");
            Map<?, ?> choice = (Map<?, ?>) choices.get(0);
            Map<?, ?> messageMap = (Map<?, ?>) choice.get("message");

            return messageMap.get("content").toString();

        } catch (Exception e) {

            return "AI service unavailable. Please follow healthy diet, exercise daily and monitor blood sugar.";

        }
    }
}