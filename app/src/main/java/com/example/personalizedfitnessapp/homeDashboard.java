package com.example.personalizedfitnessapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

public class homeDashboard extends Fragment {

    Button btnRecommend;
    Activity context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_home_dashboard, container, false);

        btnRecommend = rootview.findViewById(R.id.btnquestions);
        context = getActivity();

        btnRecommend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, question1.class);
                startActivity(intent);
            }
        });

        return rootview;
    }
}