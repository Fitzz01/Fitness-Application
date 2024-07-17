package com.example.personalizedfitnessapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class stepTracker extends AppCompatActivity implements SensorEventListener {

    private SensorManager mSensorManager = null;
    private Sensor stepSensor;
    private int totalSteps = 0;
    private int previewTotalSteps = 0;
    private ProgressBar progressBar;
    private TextView steps;
    private Button btnSteps, btnGoBackSTrack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step_tracker);

        progressBar         = findViewById(R.id.progressBar);
        steps               = findViewById(R.id.stepsCount);
        btnSteps            = findViewById(R.id.buttonStopTracker);
        btnGoBackSTrack     = findViewById(R.id.buttonGoBackStepTrack);

        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        stepSensor     = mSensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);

        //resetSteps();
        reset();
        btnGoBack();
    }

    protected void btnGoBack(){
        btnGoBackSTrack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(stepTracker.this, featuresExercise.class);
                startActivity(intent);
            }
        });
    }

    protected void onResume(){
        super.onResume();

        if(stepSensor == null){
            Toast.makeText(this, "This device has no sensor", Toast.LENGTH_SHORT).show();
        }
        else {
            mSensorManager.registerListener(this, stepSensor, SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    protected void onPause(){
        super.onPause();
        mSensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.sensor.getType() == Sensor.TYPE_STEP_COUNTER){
            totalSteps = (int) event.values[0];
            int currentSteps = totalSteps-previewTotalSteps;
            steps.setText(String.valueOf(currentSteps));
            progressBar.setProgress(currentSteps);
        }
    }

    private void reset(){
        btnSteps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                previewTotalSteps = totalSteps;
                steps.setText("0");
                progressBar.setProgress(0);
                saveData();
            }
        });
    }

    /*private void resetSteps(){
        steps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(stepTracker.this, "Long Press to reset steps", Toast.LENGTH_SHORT).show();
            }
        });

        steps.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                previewTotalSteps = totalSteps;
                steps.setText("0");
                progressBar.setProgress(0);
                saveData();
                return true;
            }
        });
    }*/

    private void saveData(){
        SharedPreferences sharedPref    = getSharedPreferences("myPref", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("key1", String.valueOf(previewTotalSteps));
        editor.apply();
    }

    private void loadData(){
        SharedPreferences sharedPref = getSharedPreferences("myPref", Context.MODE_PRIVATE);
        int savedNumber = (int) sharedPref.getFloat("key1", 0f);
        previewTotalSteps = savedNumber;
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}