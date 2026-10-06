from flask import Flask, request, jsonify
import pickle
import numpy as np
from flask_cors import CORS
import os

app = Flask(__name__)
CORS(app)

model_path = os.path.join(os.path.dirname(__file__), "model.pkl.sav")
if not os.path.exists(model_path):
    model_path = "model.pkl.sav"

model = pickle.load(open(model_path, "rb"))

@app.route("/health", methods=["GET"])
def health():
    return jsonify({"status": "ok"})

@app.route("/predict", methods=["POST"])
def predict():
    data = request.json

    values = np.array([[
        float(data.get("pregnancies", 0)),
        float(data.get("glucose", 0)),
        float(data.get("blood_pressure", 0)),
        float(data.get("skin_thickness", 0)),
        float(data.get("insulin", 0)),
        float(data.get("bmi", 0)),
        float(data.get("dpf", 0)),
        float(data.get("age", 0))
    ]])

    prediction = model.predict(values)
    result = "Diabetic" if prediction[0] == 1 else "Not Diabetic"

    return jsonify({"prediction": result})

if __name__ == "__main__":
    port = int(os.environ.get("PORT", 5000))
    app.run(host="0.0.0.0", port=port)