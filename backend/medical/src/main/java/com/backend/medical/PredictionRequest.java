package com.backend.medical;

import lombok.Data;

@Data
public class PredictionRequest {

    private int pregnancies;
    private int glucose;
    private int blood_pressure;
    private int skin_thickness;
    private int insulin;
    private double bmi;
    private double dpf;
    private int age;

}