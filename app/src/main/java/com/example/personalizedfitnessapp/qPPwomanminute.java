package com.example.personalizedfitnessapp;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class qPPwomanminute extends AppCompatActivity {

    Spinner ppwomanExercise;
    Button btnPpwomanRecommend;
    TextView recommendPpwomanExercise;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qppwomanminute);

        ppwomanExercise = (Spinner)findViewById(R.id.ppwomanExercise);
        btnPpwomanRecommend = (Button)findViewById(R.id.btnRecommendPpwomanExercise);
        recommendPpwomanExercise = (TextView)findViewById(R.id.textRecommend2);

        ArrayAdapter<CharSequence> adapterPpwomanExercise = ArrayAdapter.createFromResource(this, R.array.spinner_choise_minutes, android.R.layout.simple_spinner_item);
        adapterPpwomanExercise.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ppwomanExercise.setAdapter(adapterPpwomanExercise);

        btnPpwomanRecommend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String spinnerPpwomanExercise = ppwomanExercise.getSelectedItem().toString();
                String recommendation = rPpwomanExercise(spinnerPpwomanExercise);
                recommendPpwomanExercise.setText(recommendation);
            }
        });
    }

    private String rPpwomanExercise(String spinnerPpwomanExercise){

        String recommendationExercise = "";

        if(spinnerPpwomanExercise.equals("30")){
            recommendationExercise = getResources().getString(R.string.childExer1);
        }
        else if (spinnerPpwomanExercise.equals("45")) {
            recommendationExercise = getResources().getString(R.string.childExer2);
        }
        else if (spinnerPpwomanExercise.equals("60")) {
            recommendationExercise = getResources().getString(R.string.childExer3);
        }
        return recommendationExercise;
    }
}