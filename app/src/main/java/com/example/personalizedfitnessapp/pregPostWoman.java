package com.example.personalizedfitnessapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class pregPostWoman extends AppCompatActivity {

    Spinner spinnerPpwoman;
    Button btnPpwoman;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preg_post_woman);

        spinnerPpwoman = (Spinner)findViewById(R.id.ppwoman);
        btnPpwoman = (Button)findViewById(R.id.btnpregpostw);

        ArrayAdapter<CharSequence> adapterppwoman = ArrayAdapter.createFromResource(this, R.array.spinner_choise, android.R.layout.simple_spinner_item);
        adapterppwoman.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPpwoman.setAdapter(adapterppwoman);

        btnPpwoman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String spinppwoman = spinnerPpwoman.getSelectedItem().toString();
                boolean gender = conPPwoman(spinppwoman);
            }
        });
    }

    private boolean conPPwoman(String spinppwoman){
        if(spinppwoman.equals("No"))
        {
            Intent intent = new Intent(pregPostWoman.this, chronicCondition.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        }
        else if (spinppwoman.equals("Yes"))
        {
            Intent intent = new Intent(pregPostWoman.this, qPPwomanminute.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        }
        return true;
    }

}