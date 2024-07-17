package com.example.personalizedfitnessapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class featuresExercise extends Fragment {

    Activity context;
    Button bmicalc, stepTrac;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_features_exercise, container, false);

        bmicalc  = rootview.findViewById(R.id.buttonBMIcalc);
        stepTrac = rootview.findViewById(R.id.buttonStepTracker);
        context  = getActivity();

        //function button to link bmi calculator activity
        bmicalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, bmiCalculator.class);
                startActivity(i);
            }
        });

        //function button to link step tracker activity
        stepTrac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, stepTracker.class);
                startActivity(i);
            }
        });

        return rootview;
    }
}