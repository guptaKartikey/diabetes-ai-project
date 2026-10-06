import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { PredictService } from '../services/predict.service';

@Component({
  selector: 'app-predict',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './predict.html',
  styleUrls: ['./predict.css']
})
export class Predict {

  formData = {
    pregnancies: 0,
    glucose: 0,
    blood_pressure: 0,
    skin_thickness: 0,
    insulin: 0,
    bmi: 0,
    dpf: 0,
    age: 0
  };

  result: any = null;
  recommendation: string = '';
  isLoading: boolean = false;
  errorMessage: string = '';

  constructor(private predictService: PredictService) {}

  submitForm() {
    this.isLoading = true;
    this.errorMessage = '';
    this.result = null;
    this.recommendation = '';

    this.predictService.predict(this.formData).subscribe({
      next: (res: any) => {
        this.isLoading = false;
        this.result = { prediction: res.prediction };
        this.recommendation = res.recommendation;
      },
      error: (err: any) => {
        this.isLoading = false;
        this.errorMessage = 'Error connecting to backend service. Please check your connection or wait a moment for the server to wake up.';
        console.error('Prediction error:', err);
      }
    });
  }
}