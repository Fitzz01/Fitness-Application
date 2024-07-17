package com.example.personalizedfitnessapp;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class qchildminute extends AppCompatActivity {

    Spinner childExercise;
    Button btnChildRecommend;
    TextView recommendChildExercise;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qchildminute);

        childExercise = (Spinner)findViewById(R.id.childMinutes);
        btnChildRecommend = (Button)findViewById(R.id.btnRecommendChildExercise);
        recommendChildExercise = (TextView)findViewById(R.id.textRecommend1);

        ArrayAdapter<CharSequence> adapterchildExercise = ArrayAdapter.createFromResource(this, R.array.spinner_choise_minutes, android.R.layout.simple_spinner_item);
        adapterchildExercise.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        childExercise.setAdapter(adapterchildExercise);

        btnChildRecommend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String spinnerChildExercise = childExercise.getSelectedItem().toString();
                String recommendation = rChildExercise(spinnerChildExercise);
                recommendChildExercise.setText(recommendation);
            }
        });
    }

    private String rChildExercise(String spinnerChildExercise){

        String recommendationExercise = "";

        if(spinnerChildExercise.equals("30")){
            recommendationExercise = getResources().getString(R.string.childExer1);
        }
        else if (spinnerChildExercise.equals("45")) {
            recommendationExercise = getResources().getString(R.string.childExer2);
        }
        else if (spinnerChildExercise.equals("60")) {
            recommendationExercise = getResources().getString(R.string.childExer3);
        }

        return recommendationExercise;
    }

}