package com.example.personalizedfitnessapp;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class qadultminute extends AppCompatActivity {

    Spinner adultExercise;
    Button btnAdultRecommend;
    TextView recommendAdultExercise;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qadultminute);

        adultExercise = (Spinner)findViewById(R.id.adultMinutes);
        btnAdultRecommend = (Button)findViewById(R.id.btnRecommendAdultExercise);
        recommendAdultExercise = (TextView)findViewById(R.id.textRecommend3);

        ArrayAdapter<CharSequence> adapteradultExercise = ArrayAdapter.createFromResource(this, R.array.spinner_choise_minutes, android.R.layout.simple_spinner_item);
        adapteradultExercise.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adultExercise.setAdapter(adapteradultExercise);

        btnAdultRecommend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String spinnerAdultExercise = adultExercise.getSelectedItem().toString();
                String recommendation = rAdultExercise(spinnerAdultExercise);
                recommendAdultExercise.setText(recommendation);
            }
        });
    }

    private String rAdultExercise(String spinnerAdultExercise){

        String recommendationExercise = "";

        if(spinnerAdultExercise.equals("30")){
            recommendationExercise = getResources().getString(R.string.childExer1);
        }
        else if (spinnerAdultExercise.equals("45")) {
            recommendationExercise = getResources().getString(R.string.childExer2);
        }
        else if (spinnerAdultExercise.equals("60")) {
            recommendationExercise = getResources().getString(R.string.childExer3);
        }

        return recommendationExercise;
    }
}