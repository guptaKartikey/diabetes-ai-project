package com.backend.medical.controller;

import com.backend.medical.service.AIService;
import com.backend.medical.PredictionRequest;
import com.backend.medical.service.PredictionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class PredictionController {

    @Autowired
    private PredictionService predictionService;

  @Autowired
private AIService aiService;

    @PostMapping("/predict")
    public Map<String, Object> predict(@RequestBody PredictionRequest request) {

        Map<String, Object> data = new HashMap<>();
        data.put("pregnancies", request.getPregnancies());
        data.put("glucose", request.getGlucose());
        data.put("blood_pressure", request.getBlood_pressure());
        data.put("skin_thickness", request.getSkin_thickness());
        data.put("insulin", request.getInsulin());
        data.put("bmi", request.getBmi());
        data.put("dpf", request.getDpf());
        data.put("age", request.getAge());

        // Call Python ML model to get prediction
        String prediction = predictionService.getPrediction(data);
            
        String recommendation = aiService.getRecommendation(data, prediction);
        Map<String, Object> response = new HashMap<>();
        response.put("prediction", prediction);  // only prediction
         
        response.put("recommendation", recommendation);

        return response;
    }
}