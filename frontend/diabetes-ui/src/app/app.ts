import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Predict } from "./predict/predict";

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, Predict],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('diabetes-ui');
}
