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

  result: any;
   

   recommendation: string = '';

    

  constructor(private predictService: PredictService) {}

 submitForm() {
  this.predictService.predict(this.formData).subscribe(res => {

     this.result = { prediction: res.prediction };


      // store recommendation from backend
      this.recommendation = res.recommendation;


  });
}
}