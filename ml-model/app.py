from flask import Flask, request, jsonify
import pickle
import numpy as np

app = Flask(__name__)

model = pickle.load(open("diabetes_model.sav","rb"))

@app.route("/predict", methods=["POST"])
def predict():

    data = request.json

    values = np.array([[data["pregnancies"],
                        data["glucose"],
                        data["blood_pressure"],
                        data["skin_thickness"],
                        data["insulin"],
                        data["bmi"],
                        data["dpf"],
                        data["age"]]])

    prediction = model.predict(values)

    result = "Diabetic" if prediction[0]==1 else "Not Diabetic"

    return jsonify({"prediction": result})

if __name__ == "__main__":
    app.run(port=5000)