package com.backend.medical.controller;

import com.backend.medical.service.AIService;
import com.backend.medical.service.PredictionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
public class PredictionController {

    @Autowired
    private PredictionService predictionService;

    @Autowired
    private AIService aiService;

    @PostMapping("/predict")
    public Map<String, Object> predict(@RequestBody Map<String, Object> request) {

        Map<String, Object> data = new HashMap<>();
        data.put("pregnancies", request.getOrDefault("pregnancies", 0));
        data.put("glucose", request.getOrDefault("glucose", 0));
        data.put("blood_pressure", request.getOrDefault("blood_pressure", request.getOrDefault("bloodPressure", 0)));
        data.put("skin_thickness", request.getOrDefault("skin_thickness", request.getOrDefault("skinThickness", 0)));
        data.put("insulin", request.getOrDefault("insulin", 0));
        data.put("bmi", request.getOrDefault("bmi", 0));
        data.put("dpf", request.getOrDefault("dpf", 0));
        data.put("age", request.getOrDefault("age", 0));

        // Call Python ML model to get prediction
        String prediction = predictionService.getPrediction(data);
            
        String recommendation = aiService.getRecommendation(data, prediction);
        
        Map<String, Object> response = new HashMap<>();
        response.put("prediction", prediction);
        response.put("recommendation", recommendation);

        return response;
    }
}