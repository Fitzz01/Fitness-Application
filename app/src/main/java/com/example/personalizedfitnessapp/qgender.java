package com.example.personalizedfitnessapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class qgender extends AppCompatActivity {

    Spinner spinnerGender;
    Button btnGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qgender);

        spinnerGender = (Spinner)findViewById(R.id.genderUser);
        btnGender = (Button)findViewById(R.id.btnGender);

        ArrayAdapter<CharSequence> adaptergender = ArrayAdapter.createFromResource(this, R.array.spinner_choise_gender, android.R.layout.simple_spinner_item);
        adaptergender.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerGender.setAdapter(adaptergender);

        btnGender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String spinUser = spinnerGender.getSelectedItem().toString();
                boolean gender = gUser(spinUser);
            }
        });
    }

    private boolean gUser(String spinUser){
        if(spinUser.equals("Male"))
        {
            Intent intent = new Intent(qgender.this, chronicCondition.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        }
        else if (spinUser.equals("Female"))
        {
            Intent intent = new Intent(qgender.this, pregPostWoman.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        }
        return true;
    }
}