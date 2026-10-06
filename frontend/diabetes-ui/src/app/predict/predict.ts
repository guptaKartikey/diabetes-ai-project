import { Component, ChangeDetectorRef } from '@angular/core';
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
    glucose: 120,
    blood_pressure: 70,
    skin_thickness: 20,
    insulin: 79,
    bmi: 25.0,
    dpf: 0.5,
    age: 33
  };

  result: any = null;
  recommendation: string = '';
  isLoading: boolean = false;
  errorMessage: string = '';

  constructor(
    private predictService: PredictService,
    private cdr: ChangeDetectorRef
  ) {}

  submitForm() {
    this.isLoading = true;
    this.errorMessage = '';
    this.result = null;
    this.recommendation = '';
    this.cdr.detectChanges();

    const payload = {
      pregnancies: Number(this.formData.pregnancies) || 0,
      glucose: Number(this.formData.glucose) || 0,
      blood_pressure: Number(this.formData.blood_pressure) || 0,
      skin_thickness: Number(this.formData.skin_thickness) || 0,
      insulin: Number(this.formData.insulin) || 0,
      bmi: Number(this.formData.bmi) || 0,
      dpf: Number(this.formData.dpf) || 0,
      age: Number(this.formData.age) || 0
    };

    console.log('Sending diabetes prediction request:', payload);

    this.predictService.predict(payload).subscribe({
      next: (res: any) => {
        console.log('Received prediction response:', res);
        this.isLoading = false;
        this.result = { prediction: res.prediction || 'Unknown' };
        this.recommendation = res.recommendation || '';
        this.cdr.detectChanges();
      },
      error: (err: any) => {
        console.error('Prediction request error:', err);
        this.isLoading = false;
        this.errorMessage = 'Could not get prediction from server. Please wait a moment and try again.';
        this.cdr.detectChanges();
      }
    });
  }
}