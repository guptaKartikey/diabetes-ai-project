# 🩺 AI Diabetes Prediction & Health Recommendation System

An end-to-end full-stack AI healthcare web application that predicts diabetes risk based on diagnostic measurements and provides personalized AI-generated health recommendations using Groq (LLaMA 3).

---

## 🌐 Live Demo

* **Live Web App:** [https://diabetes-ai-prediction.netlify.app/](https://diabetes-ai-prediction.netlify.app/)
* **Backend API:** [https://diabetes-ai-project-ai.onrender.com](https://diabetes-ai-project-ai.onrender.com)

---

## 🚀 Key Features

* **Instant Risk Prediction:** Machine Learning model trained on clinical diagnostic data to assess diabetes risk.
* **AI Medical Assistant:** Dynamic health recommendations and lifestyle guidance powered by Groq LLaMA 3.
* **Modern Reactive UI:** Clean, responsive user interface built with Angular 19.
* **Scalable Architecture:** Spring Boot REST backend with an embedded Python ML microservice packaged in Docker.
* **Production Ready:** Automated CI/CD deployment on Netlify and Render.

---

## 🏗️ Architecture

```
┌────────────────────────────────┐
│   Angular Frontend (Netlify)   │
│  diabetes-ai-prediction.app    │
└──────────────┬─────────────────┘
               │  POST /api/predict
               ▼
┌────────────────────────────────┐
│  Spring Boot Backend (Render)  │
└───────┬────────────────┬───────┘
        │                │
        │ POST /predict  │ Chat Completions
        ▼                ▼
┌──────────────────┐  ┌──────────────────┐
│ Python ML Model  │  │  Groq AI API     │
│ (Flask + Scikit) │  │  (LLaMA 3 Model) │
└──────────────────┘  └──────────────────┘
```

---

## 🛠️ Tech Stack

### **Frontend**
* **Framework:** Angular 19 (Standalone Components)
* **Styling:** Custom CSS with modern card UI and responsive layout
* **Hosting:** Netlify

### **Backend & AI**
* **Backend Framework:** Java 17, Spring Boot 3, Spring Web
* **ML Model Service:** Python 3, Flask, Scikit-Learn, NumPy, Pandas, Gunicorn
* **LLM Engine:** Groq API (LLaMA 3.1 8B Instant)
* **Containerization:** Docker (Multi-stage build combining Java & Python)
* **Hosting:** Render

---

## 📊 Diagnostic Parameters

| Parameter | Description |
| :--- | :--- |
| **Pregnancies** | Number of times pregnant |
| **Glucose Level** | Plasma glucose concentration (2 hours in an oral glucose tolerance test) |
| **Blood Pressure** | Diastolic blood pressure (mm Hg) |
| **Skin Thickness** | Triceps skin fold thickness (mm) |
| **Insulin** | 2-Hour serum insulin (mu U/ml) |
| **BMI** | Body mass index (weight in kg / (height in m)²) |
| **Diabetes Pedigree Function (DPF)** | Genetic predisposition score |
| **Age** | Age in years |

---

## 🔌 API Reference

### **Predict Diabetes Risk**

`POST /api/predict`

#### **Request Body:**
```json
{
  "pregnancies": 2,
  "glucose": 130,
  "blood_pressure": 80,
  "skin_thickness": 25,
  "insulin": 90,
  "bmi": 28.5,
  "dpf": 0.65,
  "age": 45
}
```

#### **Response Body:**
```json
{
  "prediction": "Diabetic",
  "recommendation": "1. Maintain a low-glycemic, fiber-rich diet.\n2. Engage in 30 minutes of moderate exercise daily.\n3. Regularly monitor blood glucose levels and consult a physician."
}
```

---

## 💻 Local Development Setup

### **Prerequisites**
* Java 17+ & Maven
* Node.js 18+ & npm
* Python 3.10+

### **1. Run Python ML Service**
```bash
cd ml_model
pip install -r requirements.txt
python app.py
```

### **2. Run Spring Boot Backend**
```bash
cd backend/medical
./mvnw spring-boot:run
```

### **3. Run Angular Frontend**
```bash
cd frontend/diabetes-ui
npm install
npm start
```
Open [http://localhost:4200](http://localhost:4200) in your browser.

---

## 🐳 Docker Deployment

To build and run the entire unified backend locally:

```bash
docker build -t diabetes-ai-backend .
docker run -p 8080:8080 -e GROQ_API_KEY="your_groq_api_key" diabetes-ai-backend
```

---

## 👤 Author

* **Kartikey Gupta** - [@guptaKartikey](https://github.com/guptaKartikey)

---

## 📄 License

This project is licensed under the MIT License.
