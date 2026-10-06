# 🩺 AI Diabetes Prediction & Health Recommendation System

<p align="center">
  <strong>An End-to-End Full-Stack AI Healthcare Application</strong>
</p>

<p align="center">
  Predict diabetes risk using Machine Learning and receive AI-generated health & lifestyle recommendations powered by Groq LLaMA.
</p>

<p align="center">

[![Live Demo](https://img.shields.io/badge/🌐_Live-Demo-success?style=for-the-badge)](https://diabetes-ai-prediction.netlify.app/)
[![Backend API](https://img.shields.io/badge/⚙️_Backend-Render-blue?style=for-the-badge)](https://diabetes-ai-project-ai.onrender.com)
[![GitHub](https://img.shields.io/badge/GitHub-Repository-black?style=for-the-badge&logo=github)](https://github.com/guptaKartikey)

</p>

<p align="center">

![Angular](https://img.shields.io/badge/Angular-19-DD0031?style=flat-square&logo=angular&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3-6DB33F?style=flat-square&logo=springboot&logoColor=white)
![Python](https://img.shields.io/badge/Python-3.10+-3776AB?style=flat-square&logo=python&logoColor=white)
![Flask](https://img.shields.io/badge/Flask-ML_Service-black?style=flat-square&logo=flask)
![Groq](https://img.shields.io/badge/Groq-LLaMA-orange?style=flat-square)
![Docker](https://img.shields.io/badge/Docker-Containerized-2496ED?style=flat-square&logo=docker&logoColor=white)
![Netlify](https://img.shields.io/badge/Frontend-Netlify-00C7B7?style=flat-square&logo=netlify&logoColor=white)
![Render](https://img.shields.io/badge/Backend-Render-46E3B7?style=flat-square)

</p>

---

## 🌐 Live Application

### 🚀 Try the Project

| Component | Link |
|---|---|
| 🌐 **Live Web Application** | [Open Diabetes AI](https://diabetes-ai-prediction.netlify.app/) |
| ⚙️ **Spring Boot Backend** | [Open Backend API](https://diabetes-ai-project-ai.onrender.com) |
| 💻 **GitHub Repository** | [View Source Code](https://github.com/guptaKartikey) |

> 💡 **Tip:** Open the live application and enter the diagnostic parameters to see the complete prediction workflow.

---

## 📑 Table of Contents

- [✨ Overview](#-overview)
- [🚀 Key Features](#-key-features)
- [🔄 How It Works](#-how-it-works)
- [🏗️ System Architecture](#️-system-architecture)
- [🧠 Machine Learning](#-machine-learning)
- [🤖 AI Recommendation Engine](#-ai-recommendation-engine)
- [🛠️ Tech Stack](#️-tech-stack)
- [📊 Diagnostic Parameters](#-diagnostic-parameters)
- [🔌 API Reference](#-api-reference)
- [💻 Local Development](#-local-development)
- [🐳 Docker Deployment](#-docker-deployment)
- [📸 Screenshots](#-screenshots)
- [🔐 Environment Variables](#-environment-variables)
- [🔮 Future Enhancements](#-future-enhancements)
- [👤 Author](#-author)
- [⚠️ Medical Disclaimer](#️-medical-disclaimer)
- [📄 License](#-license)

---

# ✨ Overview

**AI Diabetes Prediction & Health Recommendation System** is an end-to-end full-stack healthcare application that combines:

- 🧠 Machine Learning
- 🤖 Generative AI
- 🌐 Angular
- ☕ Spring Boot
- 🐍 Python
- 🔌 REST APIs
- 🐳 Docker
- ☁️ Cloud Deployment

The application accepts common diabetes diagnostic parameters, sends them to a trained Machine Learning model, predicts diabetes risk, and then generates personalized health and lifestyle recommendations using the **Groq API with LLaMA**.

### 🎯 Main Goal

The goal of this project is to demonstrate how a Machine Learning model can be integrated into a modern full-stack web application and combined with Generative AI to create an interactive healthcare-oriented system.

---

# 🚀 Key Features

### 🧠 1. Instant Diabetes Risk Prediction

Enter diagnostic information and receive a Machine Learning based prediction.

The system processes:

- Pregnancies
- Glucose
- Blood Pressure
- Skin Thickness
- Insulin
- BMI
- Diabetes Pedigree Function
- Age

---

### 🤖 2. AI Health Recommendation Engine

After prediction, the application communicates with the **Groq API** to generate contextual health and lifestyle recommendations.

Recommendations can include:

- 🥗 Dietary guidance
- 🏃 Physical activity suggestions
- 🩸 Blood glucose monitoring guidance
- 💤 Lifestyle improvements
- 👨‍⚕️ Recommendation to consult a healthcare professional

---

### 🎨 3. Modern Reactive UI

The frontend is built using **Angular 19** with a responsive interface.

Features include:

- Clean card-based UI
- Responsive layout
- Interactive form
- Prediction result display
- AI recommendation section
- Loading states
- Error handling

---

### ⚙️ 4. Full-Stack REST Architecture

The application follows a layered architecture:

```text
Angular
   ↓
Spring Boot REST API
   ↓
Python ML Service
   ↓
Machine Learning Model
