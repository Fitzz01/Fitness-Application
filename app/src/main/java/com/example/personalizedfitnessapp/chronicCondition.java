package com.example.personalizedfitnessapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class chronicCondition extends AppCompatActivity {

    Spinner spinnerCcUser;
    Button btnCcUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chronic_condition);

        spinnerCcUser = (Spinner)findViewById(R.id.ccUser);
        btnCcUser = (Button)findViewById(R.id.btnCcUser);

        ArrayAdapter<CharSequence> adapterCcUser = ArrayAdapter.createFromResource(this, R.array.spinner_choise, android.R.layout.simple_spinner_item);
        adapterCcUser.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCcUser.setAdapter(adapterCcUser);

        btnCcUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String spinCcUser = spinnerCcUser.getSelectedItem().toString();
                boolean gender = conCcUser(spinCcUser);
            }
        });
    }

    private boolean conCcUser(String spinCcUser){
        if(spinCcUser.equals("No"))
        {
            Intent intent = new Intent(chronicCondition.this, qadultminute.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        }
        else if (spinCcUser.equals("Yes"))
        {
            Intent intent = new Intent(chronicCondition.this, qadultchrominute.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        }
        return true;
    }
}