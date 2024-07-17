package com.example.personalizedfitnessapp;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class qadultchrominute extends AppCompatActivity {

    Spinner adultChroExercise;
    Button btnAdultChroRecommend;
    TextView recommendAdultChroExercise;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qadultchrominute);

        adultChroExercise = (Spinner)findViewById(R.id.adultChroMinutes);
        btnAdultChroRecommend = (Button)findViewById(R.id.btnRecommendAdultChroExercise);
        recommendAdultChroExercise = (TextView)findViewById(R.id.textRecommend4);

        ArrayAdapter<CharSequence> adapteradultChroExercise = ArrayAdapter.createFromResource(this, R.array.spinner_choise_minutes, android.R.layout.simple_spinner_item);
        adapteradultChroExercise.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adultChroExercise.setAdapter(adapteradultChroExercise);

        btnAdultChroRecommend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String spinnerAdultChronicExercise = adultChroExercise.getSelectedItem().toString();
                String recommendation = rAdultChroExercise(spinnerAdultChronicExercise);
                recommendAdultChroExercise.setText(recommendation);
            }
        });
    }

    private String rAdultChroExercise(String spinnerAdultChronicExercise){

        String recommendationExercise = "";
        String recommendationFunctionalExercise = "";

        if(spinnerAdultChronicExercise.equals("30")){
            recommendationExercise = getResources().getString(R.string.childExer1);
        }
        else if (spinnerAdultChronicExercise.equals("45")) {
            recommendationExercise = getResources().getString(R.string.childExer2);
        }
        else if (spinnerAdultChronicExercise.equals("60")) {
            recommendationExercise = getResources().getString(R.string.childExer3);
        }

        return recommendationExercise + recommendationFunctionalExercise;
    }

}