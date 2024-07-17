package com.example.personalizedfitnessapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class bmiCalculator extends AppCompatActivity {

    EditText editTextHeight, editTextWeight;
    Button btnCalculate, btnGoBackBMI;
    TextView resultBmi, condBmi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_calculator);

        editTextHeight = findViewById(R.id.heightBMI);
        editTextWeight = findViewById(R.id.weightBMI);
        btnCalculate   = findViewById(R.id.buttonCalcBMI);
        resultBmi      = findViewById(R.id.resultCalcBMI);
        condBmi        = findViewById(R.id.ConditionBMI);
        btnGoBackBMI   = findViewById(R.id.buttonGoBackBMI);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float height  = Float.parseFloat(String.valueOf(editTextHeight.getText())) / 100;
                float weight  = Float.parseFloat(String.valueOf(editTextWeight.getText()));
                float bmiCalc = weight / (height * height);

                resultBmi.setText(String.format("%.2f",bmiCalc));

                if(bmiCalc < 18.5 ){
                    condBmi.setText("Underweight");
                } else if (bmiCalc < 25.0) {
                    condBmi.setText("Healhty");
                }
                else if (bmiCalc < 30.0) {
                    condBmi.setText("Overweight");
                }
                else{
                    condBmi.setText("Obese");
                }

            }
        });

        btnGoBackBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(bmiCalculator.this, featuresExercise.class);
                startActivity(intent);
            }
        });

    }
}