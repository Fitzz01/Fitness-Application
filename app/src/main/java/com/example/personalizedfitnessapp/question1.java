package com.example.personalizedfitnessapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class question1 extends AppCompatActivity {

    EditText userAge;
    Button btnage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question1);

        userAge = (EditText)findViewById(R.id.age);
        btnage = (Button)findViewById(R.id.btnNextQuestion);

        btnage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int age = Integer.parseInt(userAge.getText().toString());
                boolean nxtQuestion = goNextQuestion(age);
            }
        });
    }

    private boolean goNextQuestion(int age){

        if(age >= 5 && age <= 17)
        {
            Intent intent = new Intent(question1.this, qchildminute.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        }
        else if (age >= 18 && age <= 64)
        {
            Intent intent = new Intent(question1.this, qgender.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        }
        return true;
    }
}